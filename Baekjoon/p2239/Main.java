package p2239;

import java.util.*;
import java.io.*;

public class Main {
  static int[][] sdoku;
  static boolean flag;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    sdoku = new int[9][9];

    for (int i = 0; i < 9; i++) {
      String row = br.readLine();

      for (int j = 0; j < 9; j++) {
        sdoku[i][j] = row.charAt(j) - '0';
      }
    }

    backtracking(0);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(sdoku[i][j]);
      }
      sb.append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }

  static void backtracking(int pos) {
    if (pos == 81) {
      flag = true;
      return;
    }
    int r = pos / 9;
    int c = pos % 9;
    if (sdoku[r][c] == 0) {
      boolean[] nums = new boolean[10];
      checkRow(r, c, nums);
      checkArea(r, c, nums);
      checkColumn(r, c, nums);
      for (int i = 1; i <= 9; i++) {
        if (!nums[i]) {
          sdoku[r][c] = i;
          backtracking(pos + 1);
          if (flag) {
            return;
          }
          sdoku[r][c] = 0;
        }
      }
    } else {
      backtracking(pos + 1);
    }
  }

  static void checkRow(int r, int c, boolean[] nums) {
    for (int i = 0; i < 9; i++) {
      if (sdoku[r][i] != 0) {
        nums[sdoku[r][i]] = true;
      }
    }
  }

  static void checkArea(int r, int c, boolean[] nums) {
    int startR = r / 3 * 3;
    int startC = c / 3 * 3;
    for (int i = startR; i < startR + 3; i++) {
      for (int j = startC; j < startC + 3; j++) {
        if (sdoku[i][j] != 0) {
          nums[sdoku[i][j]] = true;
        }
      }
    }
  }

  static void checkColumn(int r, int c, boolean[] nums) {
    for (int i = 0; i < 9; i++) {
      if (sdoku[i][c] != 0) {
        nums[sdoku[i][c]] = true;
      }
    }
  }
}
