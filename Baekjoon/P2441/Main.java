package P2441;

import java.util.*;

public class Main {
    static int N;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = N; i > 0; i--) {
            for (int j = N - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
