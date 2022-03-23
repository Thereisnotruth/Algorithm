package P11066;

import java.util.*;
import java.io.*;

public class Main {
  static int T, K;
  static int[] chapter, sum;
  static int[][] dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      K = Integer.parseInt(br.readLine());

      chapter = new int[K + 1];
      sum = new int[K + 1];
      dp = new int[K + 1][K + 1];

      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= K; j++) {
        int ch = Integer.parseInt(st.nextToken());
        chapter[j] = ch;
        sum[j] = sum[j - 1] + ch;
      }

      for (int d = 1; d < K; d++) {
        for (int tx = 1; tx + d <= K; tx++) {
          int ty = tx + d;
          dp[tx][ty] = Integer.MAX_VALUE;

          for (int mid = tx; mid < ty; mid++) {
            dp[tx][ty] = Math.min(dp[tx][ty], dp[tx][mid] + dp[mid + 1][ty] + sum[ty] - sum[tx - 1]);
          }
        }
      }

      sb.append(dp[1][K] + "\n");
    }
    System.out.println(sb.toString());
    br.close();
  }
}
