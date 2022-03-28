package P1937;

import java.util.*;
import java.io.*;

public class Main {
  static int n, ans;
  static int[][] board, dp;
  static boolean[][] visited;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { -1, 1, 0, 0 };

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    dp = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        visited[i][j] = true;
        dfs(i, j);
        visited[i][j] = false;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ans = Math.max(ans, dp[i][j]);
      }
    }
    System.out.println(ans);
  }
  public static int dfs (int y, int x) {
    if (dp[y][x] != 0) {
      return dp[y][x];
    }
    boolean check = false;
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx] && board[ny][nx] > board[y][x]) {
        visited[ny][nx] = true;
        dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        visited[ny][nx] = false;
        check = true;
      }
    }
    if (!check) {
      return dp[y][x] = 1;
    }
    return dp[y][x];
  }
}
