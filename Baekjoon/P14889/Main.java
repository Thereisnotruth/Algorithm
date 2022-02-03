package P14889;

import java.util.*;
import java.io.*;

public class Main {
  static int n, answer = Integer.MAX_VALUE;
  static int[][] s;
  static boolean[] selected;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    s = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        s[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    selected = new boolean[n];

    solve(0, 0);

    System.out.println(answer);
  }
  static void solve (int idx, int cnt) {
    if (cnt == n / 2) {
      int start = 0;
      int link = 0;
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (selected[i] && selected[j]) {
            start = start + s[i][j] + s[j][i];
          }
          if (!selected[i] && !selected[j]) {
            link = link + s[i][j] + s[j][i];
          }
        }
      }
      answer = Math.min(answer, Math.abs(start - link));
      return;
    }
    for (int i = idx; i < n; i++) {
      if (!selected[i]) {
        selected[i] = true;
        solve(i, cnt + 1);
        selected[i] = false;
      }
    }
  }
}
