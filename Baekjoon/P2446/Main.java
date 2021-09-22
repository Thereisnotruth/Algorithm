package P2446;

import java.util.*;

public class Main {
    static int N;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 2 * (N - i) - 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (N - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
