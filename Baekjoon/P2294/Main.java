package P2294;

import java.util.*;

public class Main {
  static int n, k;
  static int[] coins, dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    coins = new int[n];
    dp = new int[k + 1];
    for (int i = 1; i <= k; i++) {
      dp[i] = 10001;
    }

    for (int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = coins[i]; j <= k; j++) {
        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
      }
    }

    if (dp[k] == 10001) {
      System.out.println(-1);
    } else {
      System.out.println(dp[k]);
    }
  }
  
}
