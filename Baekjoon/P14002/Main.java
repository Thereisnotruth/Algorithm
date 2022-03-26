package P14002;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int[] A, dp;
  static ArrayList[] LIS;
  static ArrayList<Integer> ans;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    A = new int[N];
    dp = new int[N];
    ans = new ArrayList<>();
    LIS = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      LIS[i] = new ArrayList<Integer>();
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < N; i++) {
      dp[i] = 1;
      LIS[i].add(A[i]);
      for (int j = 0; j < i; j++) {
        if (A[i] > A[j] && dp[i] < dp[j] + 1) {
          Collections.copy(LIS[i], LIS[j]);
          LIS[i].add(A[i]);
          dp[i] = dp[j] + 1;
        }
      }
    }
    for (int i = 0; i < N; i++) {
      if (ans.size() < LIS[i].size()) {
        ans = LIS[i];
      }
    }
    sb.append(ans.size() + "\n");
    for (int i = 0; i < ans.size(); i++) {
      sb.append(ans.get(i) + " ");
    }
    System.out.println(sb.toString());
  }

}
