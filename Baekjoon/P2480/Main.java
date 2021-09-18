package P2480;

import java.io.*;
import java.util.Scanner;

public class Main {
    static int A, B, C;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        if (A == B && B == C) {
            System.out.println(10000 + A * 1000);
        } else if (A == B && B != C || A == C && B != C || B == C && A != B) {
            if (A == B) {
                System.out.println(1000 + A * 100);
            } else if (B == C) {
                System.out.println(1000 + B * 100);
            } else {
                System.out.println(1000 + C * 100);
            }
        } else {
            int max = Math.max(A, Math.max(B, C));
            System.out.println(max * 100);
        }
    }
}
