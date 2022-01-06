package P2748;

import java.util.*;

public class Main {
  static int n;
  static long[] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    dp = new long[n + 1];

    dp[1] = 1;


    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    System.out.println(dp[n]);
  }
  
}
