package P10942;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static int[] arr;
  static int[][] dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N + 1];
    dp = new int[N + 1][N + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      dp[i][i] = 1;
      if (arr[i] == arr[i - 1]) {
        dp[i - 1][i] = 1;
      }
    }
    for (int dis = 2; dis <= N - 1; dis++) {
      for (int idx = 1; idx <= N - 1; idx++) {
        if (idx + dis > N) {
          continue;
        }
        if (arr[idx] == arr[idx + dis] && dp[idx + 1][idx + dis - 1] == 1) {
          dp[idx][idx + dis] = 1;
        }
      }
    }

    M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      sb.append(dp[S][E] + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
}
