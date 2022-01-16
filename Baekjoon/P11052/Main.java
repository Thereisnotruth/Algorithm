package P11052;

import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int[] P, dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    
    P = new int[n + 1];
    dp = new int[n + 1];
    
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }
    
    dp[1] = P[1];

    for (int i = 2; i <= n; i++) {
      dp[i] = P[i];
      for (int j = i - 1; j >= i / 2; j--) {
        dp[i] = Math.max(dp[i], dp[j] + P[i - j]);
      }
    }

    bw.write(dp[n] + "\n");
    bw.flush();
    br.close(); bw.close();

  }
}