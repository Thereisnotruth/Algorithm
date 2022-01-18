package P9465;

import java.util.*;
import java.io.*;

public class Main {
  static int T, n;
  static int[][] dp, sticker;
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    dp = new int[2][100001];
    sticker = new int[2][100001];

    T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        sticker[0][i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        sticker[1][i] = Integer.parseInt(st.nextToken());
      }
      dp[0][1] = sticker[0][1];
      dp[1][1] = sticker[1][1];

      for (int i = 2; i <= n; i++) {
        dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
        dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
      }
      sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close(); bw.close();
  }
}
