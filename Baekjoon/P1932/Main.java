package P1932;

import java.util.*;
import java.io.*;

public class Main {
  static int n, answer;
  static int[][] tri, dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    tri = new int[n + 1][n + 1];
    dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= i; j++) {
        tri[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp[1][1] = tri[1][1];
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i][j] = tri[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
      }
    }
    for (int i = 1; i <= n; i++) {
      answer = Math.max(answer, dp[n][i]);
    }
    bw.write(answer + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
}
