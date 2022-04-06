package P2631;

import java.util.*;

public class Main {
  static int N, max;
  static int[] arr, dp;
  public static void main (String[] agrs) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    arr = new int[N + 1];
    dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 1; i <= N; i++) {
      dp[i] = 1;
      for (int j = 1; j < i; j++) {
        if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
      if (max < dp[i]) {
        max = dp[i];
      }
    }

    System.out.println(N - max);
  }  
}
