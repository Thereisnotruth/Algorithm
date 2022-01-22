package P2407;

import java.util.*;
import java.math.*;

public class Main {
  static int n, m;
  static BigInteger[][] dp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    dp = new BigInteger[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i && j <= m;  j++) {
        if (i == j) {
          dp[i][j] = new BigInteger("1");
        } else if (j == 1) {
          dp[i][j] = new BigInteger(String.valueOf(i));
        } else {
          dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
        }
      }
    }
    System.out.println(dp[n][m]);
  }  
}
