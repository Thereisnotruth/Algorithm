package D2001;

import java.util.*;
import java.io.*;

public class Solution {
  static int T, N, M, max, sum;
  static int[][] dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      dp = new int[N + 1][N + 1];

      max = 0;

      for (int i = 1; i <= N; i++) {
        st = new StringTokenizer(br.readLine());

        for (int j = 1; j <= N; j++) {
          dp[i][j] = Integer.parseInt(st.nextToken());
          dp[i][j] += (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]);
        }
      }

      for (int i = 0; i <= N - M; i++) {
        for (int j = 0; j <= N - M; j++) {
          int subsum = dp[i + M][j + M] - dp[i][j + M] - dp[i + M][j] + dp[i][j];
          max = Math.max(max, subsum);
        }
      }
      sb.append("#" + t + " " + max + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }  
}
