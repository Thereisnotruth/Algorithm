package D1979;

import java.io.*;
import java.util.*;

public class Solution {
  static int T, N, K, answer;
  static int[][] board;
  static int[] dx = { 1, 0 };
  static int[] dy = { 0, 1 };
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      board = new int[N + 2][N + 2];
      answer = 0;

      for (int i = 1; i <= N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
          board[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (board[i][j] == 1) {
            if (board[i][j - 1] == 0) {
              if (dfs(i, j, 0, 1) == K) {
                answer++;
              }
            }
            if (board[i - 1][j] == 0) {
              if (dfs(i, j, 1, 1) == K) {
                answer++;
              }
            }
          }
        }
      }
      sb.append("#" + t + " " + answer + "\n");
    }

    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
  
  public static int dfs (int y, int x, int direction, int len) {
    if (board[y][x] == 0) {
      return len - 1;
    }
    int ny = y + dy[direction];
    int nx = x + dx[direction];

    return dfs(ny, nx, direction, len + 1);
  }
}
