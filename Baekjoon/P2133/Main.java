package P2133;

import java.util.*;

public class Main {
  static int n;
  static long[] dp;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    dp = new long[n + 1];

    dp[0] = 1;
    if (n >= 2) {
      dp[2] = 3;
    }

    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 2] * 3;
      for (int j = i - 4; j >= 0; j -= 2) {
        dp[i] += dp[j] * 2;
      }
    }

    System.out.println(dp[n]);
  }
  
}
