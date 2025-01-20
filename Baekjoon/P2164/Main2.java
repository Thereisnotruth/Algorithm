package P2164;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];

        // 0: 짝수, 버리기
        // 1: 홀수, 내리기
        dp[1][0] = dp[1][1] = 1;
        if (N >= 4) {
            dp[2][0] = 2;
            dp[2][1] = 1;
        }

        for (int i = 6; i <= N; i++) {
            if (i % 2 == 0) {
                // N은 짝수일 때
                // 하나를 버리고 N / 2 - 1의 홀수일 때의 index 적용
                // 4부터 2씩 증가하는 수열의 dp[i-1][1]번째 숫자의 index
                dp[i / 2][0] = dp[i / 2 - 1][1] + 1;
            } else {
                // N은 홀수
                // 하나를 내리고, 하나를 버리고, i-1의 홀수일 때의 index 적용
                // 6부터 2씩 N/2까지 2씩 증가하는 수열 + 마지막 숫자 2의 dp[i-1][1]번째 숫자의 index
                if (dp[i / 2 - 1][1] == i / 2 - 1) {
                    dp[i / 2][1] = 1;
                } else {
                    dp[i / 2][1] = dp[i / 2 - 1][1] + 2;
                }
            }

        }

        if (N == 1) {
            bw.write("1");
        } else if (N % 2 == 0) {
            bw.write(String.valueOf(dp[N / 2][0] * 2));
        } else {
            bw.write(String.valueOf(dp[N / 2][1] * 2));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
