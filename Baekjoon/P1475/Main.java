package P1475;

import java.util.*;

public class Main {
    static int[] arr;
    static String N;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLine();
        arr = new int[9];
        
        int stack = 0;
        for (int i = 0; i < N.length(); i++) {
            if (N.charAt(i) == '6' || N.charAt(i) == '9') {
                stack++;
                if (stack == 2) {
                    stack = 0;
                    arr[6]++;
                }
            } else {
                arr[N.charAt(i) - '0']++;
            }
        }

        if (stack == 1) {
            arr[6]++;
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    
}
