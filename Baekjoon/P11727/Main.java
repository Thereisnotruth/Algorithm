package P11727;

import java.util.*;

public class Main {
  static int n;
  static long[] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    dp = new long[n + 1];

    dp[1] = 1;
    if (n > 1) {
      dp[2] = 3;
    }

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
    }

    System.out.println(dp[n]);
  }
  
}
