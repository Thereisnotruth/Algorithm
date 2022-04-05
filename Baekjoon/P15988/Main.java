package P15988;

import java.util.*;

public class Main {
  static int t, n;
  static long[] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    
    dp = new long[1_000_001];

    t = sc.nextInt();

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i <= 1_000_000; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
    }

    for (int i = 0; i < t; i++) {
      n = sc.nextInt();
      sb.append(dp[n] + "\n");
    }
    System.out.println(sb.toString());
  }
}
