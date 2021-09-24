package P3273;

import java.util.*;

public class Main {
    static int N, X;
    static boolean[] arr;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new boolean[1000001];

        int max = 0;
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if (max < tmp) {
                max = tmp;
            }
            arr[tmp] = true;
        }

        X = sc.nextInt();

        int answer = 0;
        int left = 1;
        int right = max;

        while (true) {
            if (left >= right) {
                break;
            }
            if (!arr[left]) {
                left++;
            }
            if (!arr[right]) {
                right--;
            }
            if (arr[left] && arr[right]) {
                if (left + right == X) {
                    answer++;
                    left++;
                    right--;
                } else if (left + right > X) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(answer);
    }
}
