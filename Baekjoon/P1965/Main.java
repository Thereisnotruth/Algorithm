package P1965;

import java.util.*;
import java.io.*;

public class Main {
  static int n, ans;
  static int[] arr, dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    arr = new int[n + 1];
    dp = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= n; i++) {
      dp[i] = 1;
      for (int j = 1; j < i; j++) {
        if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1; 
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      if (ans < dp[i]) {
        ans = dp[i];
      }
    }
    bw.write(String.valueOf(ans));
    bw.flush();
    br.close();
    bw.close();
  }
  
}
