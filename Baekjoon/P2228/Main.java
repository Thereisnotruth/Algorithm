package P2228;

import java.util.*;

public class Main {
  static int n, m;
  static int[] sum;
  static int[][] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    sum = new int[n + 1];
    dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      sum[i] = sum[i - 1] + sc.nextInt();
    }

    for (int i = 1; i <= m; i++) {
      dp[0][i] = -3276800;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        dp[i][j] = dp[i - 1][j];
        for (int k = 1; k <= i; k++) {
          if (k >= 2) {
            dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1]);
          } else if (k == 1 && j == 1) {
            dp[i][j] = Math.max(dp[i][j], sum[i]);
          }
        }
      }
    }

    System.out.println(dp[n][m]);
  }
  
}
