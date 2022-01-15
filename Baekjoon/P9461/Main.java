package P9461;

import java.util.*;

public class Main {
  static int t, n;
  static long[] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    dp = new long[101];
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;

    for (int i = 6; i <= 100; i++) {
      dp[i] = dp[i - 1] + dp[i - 5];
    }
    for (int i = 0; i < t; i++) {
      n = sc.nextInt();
      System.out.println(dp[n]);
    }
  }
  
}
