package P5557;

import java.util.*;
import java.io.*;

public class Main {
  static int N, result;
  static int[] arr;
  static long[][] dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N - 1];
    dp = new long[21][N - 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N - 1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    result = Integer.parseInt(st.nextToken());

    dp[arr[0]][0] = 1;
    for (int i = 1; i < N - 1; i++) {
      for (int j = 0; j <= 20; j++) {
        if (dp[j][i - 1] != 0) {
          if (j + arr[i] <= 20) {
            dp[j + arr[i]][i] += dp[j][i - 1];
          }
          if (j - arr[i] >= 0) {
            dp[j - arr[i]][i] += dp[j][i - 1];
          }
        }
      }
    }
    
    bw.write(String.valueOf(dp[result][N - 2]));
    bw.flush();
    br.close();
    bw.close();
  }
  
}
