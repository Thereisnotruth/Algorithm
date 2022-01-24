package P11055;

import java.util.*;
import java.io.*;

public class Main {
  static int n, answer;
  static int[] A, dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    A = new int[n];
    dp = new int[n];
    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      dp[i] = A[i];
      for (int j = i - 1; j >= 0; j--) {
        if (A[j] < A[i] && dp[i] < A[i] + dp[j]) {
          dp[i] = A[i] + dp[j];
        }
      }
      if (answer < dp[i]) {
        answer = dp[i];
      }
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    br.close(); bw.close();
  }  
}
