package P10807;

import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[201];

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();

            if (tmp >= 0) {
                arr[tmp]++;
            } else {
                arr[100 - tmp]++;
            }
        }

        N = sc.nextInt();

        if (N >= 0) {
            System.out.println(arr[N]);
        } else {
            System.out.println(arr[100 - N]);
        }
    }
    
}
