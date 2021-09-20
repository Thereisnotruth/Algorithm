package P2439;

import java.util.*;

public class Main {
    static int N;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
