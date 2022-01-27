package P11722;

import java.util.*;

public class Main {
  static int n, answer;
  static int[] arr, dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    answer = 1;
    arr = new int[n];
    dp = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      dp[i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]);
    }
    

    System.out.println(answer);
  }
  
}
