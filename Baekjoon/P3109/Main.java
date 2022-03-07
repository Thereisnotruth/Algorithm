package P3109;

import java.util.*;

public class Main {
  static int R, C, ans;
  static char[][] board;
  static int[] dx = { 1, 1, 1 };
  static int[] dy = { -1, 0, 1 };
  static boolean[][] visited;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    R = sc.nextInt();
    C = sc.nextInt();

    board = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      board[i] = sc.next().toCharArray();
    }

    for (int i = 0; i < R; i++) {
      BFS(i, 0);
    }
    System.out.println(ans);
  }
  
  static boolean BFS (int y, int x) {
    if (x == C - 1) {
      ans++;
      return true;
    }
    for (int i = 0; i < 3; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny > -1 && ny < R && nx > -1 && nx < C && !visited[ny][nx] && board[ny][nx] == '.') {
        visited[ny][nx] = true;
        boolean check = BFS(ny, nx);
        if (check) {
          return true;
        }
      }
    }
    return false;
  }
}
