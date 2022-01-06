package P14501;

import java.util.*;

public class Main {
  static int n;
  static int[] T, P, dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    T = new int[n];
    P = new int[n];
    dp = new int[n + 1];

    for (int i = 0; i < n; i++) {
      T[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      if (i + T[i] <= n) {
        dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
      }
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
    }

    System.out.println(dp[n]);
    
  }
}
