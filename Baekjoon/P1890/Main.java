package P1890;

import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int[][] board;
  static long[][] dp;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    dp = new long[n][n];
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = 1;
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j] == 0 || (i == n - 1 && j == n - 1)) {
          continue;
        }
        int down = board[i][j] + i;
        int right = board[i][j] + j;
        if (down < n) {
          dp[down][j] += dp[i][j];
        }

        if (right < n) {
          dp[i][right] += dp[i][j];
        }
      }
    }

    System.out.println(dp[n - 1][n - 1]);
  }
  
}
