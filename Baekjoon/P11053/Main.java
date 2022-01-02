package P11053;

import java.util.*;
import java.io.*;

public class Main {
  static int N, answer;
  static int[] arr, dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    arr = new int[N];
    dp = new int[N];
    
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
      dp[i] = 1;
    }
    answer = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]);
    }
    System.out.println(answer);
  }
}
