package P10164;

import java.util.*;

public class Main {
  static int N, M, K;
  static int midY, midX, mid;
  static int[][] dp;
  static int[] dy = { 1, 0 };
  static int[] dx = { 0, 1 };
  static boolean[][] visited;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();

    dp = new int[N][M];
    visited = new boolean[N][M];

    if (K != 0) {
      if (K % M == 0) {
        midY = K / M - 1;
        midX = M - 1;
      } else {
        midY = K / M;
        K %= M;
        midX = K - 1;
      }

      visited[0][0] = true;
      dfs(0, 0, midY, midX);
    
      mid = dp[midY][midX];
      dp[midY][midX] = 0;
    
      visited[midY][midX] = true;
      dfs(midY, midX, N - 1, M - 1);

      System.out.println(mid * dp[N - 1][M - 1]);
    } else {
      visited[0][0] = true;
      dfs(0, 0, N - 1, M - 1);

      System.out.println(dp[N - 1][M - 1]);
    }
  }
  public static void dfs (int y, int x, int endY, int endX) {
    if (y == endY && x == endX) {
      dp[y][x]++;
      return;
    }

    for (int i = 0; i < 2; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (ny >= 0 && nx >= 0 && ny <= endY && nx <= endX && !visited[ny][nx]) {
        visited[ny][nx] = true;
        dfs(ny, nx, endY, endX);
        visited[ny][nx] = false;
      }
    }
  }
}
