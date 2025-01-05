package p10872;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        dp[0] = 1;

        if (N > 0)
            dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] * i;
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        br.close();
        bw.close();
    }
}
