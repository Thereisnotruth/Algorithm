package P1010;

import java.util.*;
import java.io.*;

public class Main {
  static int T, N, M;
  static int[][] dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      dp = new int [N + 1][M + 1];
      
      for (int i = 1; i <= N; i++) {
        for (int j = i; j <= M; j++) {
          if (i == j) {
            dp[i][j] = 1;
          } else if (i == 1) {
            dp[i][j] = j;
          } else {
            dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
          }
        }
      }
      sb.append(dp[N][M] + "\n");

    }
    bw.write(sb.toString());
    bw.flush();
    br.close(); bw.close();
  }
}
