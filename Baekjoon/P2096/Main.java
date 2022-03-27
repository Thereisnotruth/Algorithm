package P2096;

import java.util.*;
import java.io.*;

public class Main {
  static int N, max, min;
  static int[][] board, dpMax, dpMin;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    board = new int[N][3];
    dpMax = new int[N][3];
    dpMin = new int[N][3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < 3; i++) {
      dpMax[0][i] = board[0][i];
      dpMin[0][i] = board[0][i];
    }
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]);
          dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]);
        } else if (j == 1) {
          dpMax[i][j] = Math.max(dpMax[i - 1][j - 1], Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]));
          dpMin[i][j] = Math.min(dpMin[i - 1][j - 1], Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]));
        } else {
          dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j - 1]);
          dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i - 1][j - 1]);
        }
        dpMax[i][j] += board[i][j];
        dpMin[i][j] += board[i][j];
      }
    }
    
    max = -987654321;
    min = 987654321;
    for (int i = 0; i < 3; i++) {
      if (max < dpMax[N - 1][i]) {
        max = dpMax[N - 1][i];
      }
      if (min > dpMin[N - 1][i]) {
        min = dpMin[N - 1][i];
      }
    }
    sb.append(max + " " + min);
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
  
}
