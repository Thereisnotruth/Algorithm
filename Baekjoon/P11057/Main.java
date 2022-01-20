package P11057;

import java.util.*;

public class Main {
  static int n, answer;
  static int[][] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    dp = new int[n + 1][10];
    
    for (int i = 0; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = 0; k <= j; k++) {
          dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
        }
      }
    }

    for (int i = 0; i <= 9; i++) {
      answer = (answer + dp[n][i]) % 10007; 
    }
    System.out.println(answer);
  }
  
}
