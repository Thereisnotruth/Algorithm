package P2579;

import java.util.*;
import java.io.*;

public class Main
{
  static int N;
  static int[] scores, dp;
  static boolean cont;
  public static void main (String[] args)
  {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    scores = new int[N];
    dp = new int[N];

    for (int i = 0; i < N; i++) {
      scores[i] = sc.nextInt();
    }
    dp[0] = scores[0];
    if (N > 1) dp[1] = scores[0] + scores[1];
    if (N > 2) dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

    for (int i = 3; i < N; i++) {
      dp[i] = Math.max(dp[i - 3] + scores[i - 1] + scores[i], dp[i - 2] + scores[i]);
    }

    System.out.println(dp[N - 1]);
  }
}