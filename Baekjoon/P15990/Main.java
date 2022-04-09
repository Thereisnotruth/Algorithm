package P15990;

import java.util.*;

public class Main {
  static int T, mod = 1_000_000_009;
  static long[][] dp;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    dp = new long[100_001][4];

    T = sc.nextInt();

    dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

    for (int i = 4; i <= 100_000; i++) {
      dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
      dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
      dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
    }
    for (int i = 0; i < T; i++) {
      int tmp = sc.nextInt();
      sb.append((dp[tmp][1] + dp[tmp][2] + dp[tmp][3]) % mod + "\n");
    }
    System.out.println(sb.toString());
  }
  
}
