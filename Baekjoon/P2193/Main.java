package P2193;

import java.util.*;

public class Main {
  static int N;
  static long[] dp0, dp1;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    dp0 = new long[N + 1];
    dp1 = new long[N + 1];

    dp1[1] = 1;

    for (int i = 2; i <= N; i++) {
      dp1[i] = dp0[i - 1];
      dp0[i] = dp0[i - 1] + dp1[i - 1];
    }
    System.out.println(dp0[N] + dp1[N]);
  }  
}
