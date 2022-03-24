package P9656;

import java.util.*;

public class Main {
  static int N;
  static boolean[] dp;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    dp  = new boolean[N + 1];
    // false = SK, true = CY
    dp[1] = true;
    dp[2] = false;
    dp[3] = true;
    for (int i = 4; i <= N; i++) {
      if (dp[i - 1] || dp[i - 3]) {
        dp[i] = false;
      } else {
        dp[i] = true;
      }
    }
    if (dp[N]) {
      System.out.println("CY");
    } else {
      System.out.println("SK");
    }
  }
  
}
