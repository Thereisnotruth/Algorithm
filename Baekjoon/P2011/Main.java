package P2011;

import java.util.*;

public class Main {
  static String str;
  static int n;
  static long[] dp, one;
  static boolean check;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    str = sc.next();

    if (str.charAt(0) == '0') {
      check = true;
    }

    n = str.length();

    dp = new long[n + 1];
    one = new long[n + 1];

    dp[1] = 1;
    one[1] = 1;

    for (int i = 2; i <= n; i++) {
      int prev = str.charAt(i - 2) - '0';
      int cur = str.charAt(i - 1) - '0';
      if (cur != 0) {
        dp[i] = one[i] = dp[i - 1];
      }
      if (prev == 0 && cur == 0) {
        check = true;
      }
      cur += prev * 10;
      
      if (cur <= 26 && prev != 0) {
        dp[i] = (dp[i] + one[i - 1]) % 1000000;
      }
    }
    if (check) {
      System.out.println(0);
    } else {
      System.out.println(dp[n]);
    }
  }
}
