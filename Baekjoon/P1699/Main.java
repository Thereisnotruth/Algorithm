package P1699;

import java.util.*;

public class Main {
  static int n, ch;
  static int[] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    System.out.println(dp[n]);
  }
  
}
