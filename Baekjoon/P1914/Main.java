package P1914;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static BigInteger cnt = new BigInteger("1");
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        

        N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
        } else {
            for (int i = 0; i < N; i++) {
                cnt = cnt.multiply(new BigInteger("2"));
            }
            cnt = cnt.subtract(new BigInteger("1"));
            System.out.println(cnt);
        }
        if (N <= 20) {
            hanoi(1, 2, 3, N);
        }
    }

    static void hanoi (int start, int mid, int end, int n) {
        if (n == 1) {
            if (N <= 20) {
                System.out.println(start + " " + end);
            }
        } else {
            hanoi(start, end, mid, n - 1);
            if (N <= 20) {
                System.out.println(start + " " + end);
            }            
            hanoi(mid, start, end, n - 1);
        }
    }
}
