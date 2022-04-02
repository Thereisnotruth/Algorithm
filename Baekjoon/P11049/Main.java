package P11049;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int[][] matrix, dp;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    
    matrix = new int[N + 1][2];
    dp = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      matrix[i][0] = Integer.parseInt(st.nextToken());
      matrix[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; i + j <= N; j++) {
        dp[j][i + j] = Integer.MAX_VALUE;
        for (int k = j; k < i + j; k++) {
          dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + matrix[j][0] * matrix[k][1] * matrix[i + j][1]);
        }
      }
    }

    bw.write(String.valueOf(dp[1][N]));
    bw.flush();
    br.close();
    bw.close();
  }
  
}
