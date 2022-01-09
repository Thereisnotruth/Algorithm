package P10844;

import java.util.*;

public class Main {
  static int n;
  static long answer;
  static long[][] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    dp = new long[10][n + 1];

    for (int i = 1; i <= 9; i++) {
      dp[i][1] = 1;
    }
    for (int i = 2; i <= n; i++) {
      dp[0][i] = dp[1][i - 1];
      for (int j = 1; j <= 8; j++) {
        dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % 1000000000;
      }
      dp[9][i] = dp[8][i - 1];
    }

    for (int i = 0; i <= 9; i++) {
      answer += dp[i][n];
    }
    System.out.println(answer % 1000000000);
    
  }
  
}
