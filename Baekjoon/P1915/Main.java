package P1915;

import java.util.*;

public class Main {
  static int n, m, ans;
  static int[][] dp;
  static char[][] board;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    dp = new int[n + 1][m + 1];
    board = new char[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      String row = sc.next();
      for (int j = 1; j <= m; j++) {
        board[i][j] = row.charAt(j - 1);
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (board[i][j] == '1') {
          if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0 && dp[i - 1][j - 1] != 0) {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          } else {
            dp[i][j] = 1;
          }
        }
        if (ans < dp[i][j]) {
          ans = dp[i][j];
        }
      }
    }

    System.out.println(ans * ans);
  }
}
