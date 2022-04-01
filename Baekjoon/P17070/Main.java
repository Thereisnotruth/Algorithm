package P17070;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int[][] board, dp;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    
    board = new int[N + 1][N + 1];
    dp = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[1][1] = 1;
    dp[1][2] = 1;
    
    dfs(0, 1, 2);

    bw.write(dp[N][N] + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
  public static void dfs (int direction, int y, int x) {
    if (y == N && x == N) {
      return;
    }
    int ny, nx;
    if (direction == 0) { // 가로
      // 가로
      ny = y;
      nx = x + 1;
      if (ny <= N && nx <= N && board[ny][nx] == 0) {
        dp[ny][nx]++;
        dfs(0, ny, nx);
      }
    } else if (direction == 1) { // 세로
      // 세로
      ny = y + 1;
      nx = x;
      if (ny <= N && nx <= N && board[ny][nx] == 0) {
        dp[ny][nx]++;
        dfs(1, ny, nx);
      }
    } else { // 대각선
      // 가로
      ny = y;
      nx = x + 1;
      if (ny <= N && nx <= N && board[ny][nx] == 0) {
        dp[ny][nx]++;
        dfs(0, ny, nx);
      }
      // 세로
      ny = y + 1;
      nx = x;
      if (ny <= N && nx <= N && board[ny][nx] == 0) {
        dp[ny][nx]++;
        dfs(1, ny, nx);
      }
    }
    // 대각선
    ny = y + 1;
    nx = x + 1;
    if (ny <= N && nx <= N && board[ny][nx] == 0 && board[y][nx] == 0 && board[ny][x] == 0) {
      dp[ny][nx]++;
      dfs(2, ny, nx);
    }
  }
}
