package p2342;

import java.util.*;

import javax.swing.ImageIcon;

import java.io.*;

public class Main {
  static List<Integer> list;
  static int[][][] dp;
  static int ans = 987654321;
  static int[][] scoreTable = {
      { 0, 2, 2, 2, 2 },
      { 0, 1, 3, 4, 3 },
      { 0, 3, 1, 3, 4 },
      { 0, 4, 3, 1, 3 },
      { 0, 3, 4, 3, 1 }
  };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    list = new ArrayList<Integer>();
    while (st.hasMoreElements()) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    list.remove(list.size() - 1);
    dp = new int[list.size() + 1][5][5];

    for (int i = 1; i < list.size(); i++) {
      int panel = list.get(i);
      for (int l = 0; l < 5; l++) {
        for (int r = 0; r < 5; r++) {
          // dp[i][l][panel] = Math.min(dp[i - 1][l][r] + scoreTable[r][panel])
        }
      }
    }

    bw.write(ans + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
}
