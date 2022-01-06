package P1912;

import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int[] arr, dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    
    arr = new int[n];
    dp = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];

    int max = dp[0];
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
      max = Math.max(max, dp[i]);
    }

    bw.write(max + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
  
}
