package P11660;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, x1, y1, x2, y2;
  static int[][] board, dp;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N + 1][N + 1];
    dp = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == 1) {
          dp[i][j] = dp[i][j - 1] + board[i][j];
        } else if (j == 1) {
          dp[i][j] = dp[i - 1][j] + board[i][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
        }
      }
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());

      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());

      sb.append((dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]) + "\n");

    }
    System.out.println(sb.toString());
    br.close();
  }
  
}
