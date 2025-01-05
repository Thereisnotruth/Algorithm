package P1914;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static BigInteger cnt = new BigInteger("1");
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("1\n");
        } else {
            for (int i = 0; i < N; i++) {
                cnt = cnt.multiply(new BigInteger("2"));
            }
            cnt = cnt.subtract(new BigInteger("1"));
            bw.write(cnt + "\n");
        }
        if (N <= 20) {
            hanoi(1, 2, 3, N);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void hanoi(int start, int mid, int end, int n) throws Exception {
        if (n == 0)
            return;
        if (n == 1) {
            if (N <= 20) {
                bw.write(start + " " + end + "\n");
            }
        } else {
            hanoi(start, end, mid, n - 1);
            if (N <= 20) {
                bw.write(start + " " + end + "\n");
            }
            hanoi(mid, start, end, n - 1);
        }
    }
}
