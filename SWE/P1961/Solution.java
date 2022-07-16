package P1961;


import java.util.*;
import java.io.*;

public class Solution {
  static int T, N;
  static int[][] board, deg90, deg180, deg270;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    
    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());

      board = new int[N][N];
      deg90 = new int[N][N];
      deg180 = new int[N][N];
      deg270 = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < N; j++) {
          board[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      rotate(board, deg90);
      rotate(deg90, deg180);
      rotate(deg180, deg270);
      
      sb.append("#" + t + "\n");
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          sb.append(deg90[i][j]);
        }
        sb.append(" ");
        for (int j = 0; j < N; j++) {
          sb.append(deg180[i][j]);
        }
        sb.append(" ");
        for (int j = 0; j < N; j++) {
          sb.append(deg270[i][j]);
        }
        sb.append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
  public static void rotate (int[][] base, int[][] rotation) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        rotation[i][j] = base[N - 1 - j][i];
      }
    }
  }
}
