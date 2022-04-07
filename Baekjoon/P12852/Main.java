package P12852;

import java.util.*;

public class Main {
  static int N, minIdx;
  static Node[] dp;
  static class Node {
    int prev, n;
    public Node (int p, int n) {
      this.prev = p;
      this.n = n;
    }
  }
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    N = sc.nextInt();
    
    dp = new Node[N + 1];

    dp[1] = new Node(0, 0);

    for (int i = 2; i <= N; i++) {
      if (i % 3 == 0 && i % 2 == 0) {
        if (dp[i / 3].n > dp[i / 2].n) {
          if (dp[i / 2].n > dp[i - 1].n) {
            minIdx = i - 1;
          } else {
            minIdx = i / 2;
          }
        } else {
          if (dp[i / 3].n > dp[i - 1].n) {
            minIdx = i - 1;
          } else {
            minIdx = i / 3;
          }
        }
      } else if (i % 3 == 0) {
        if (dp[i / 3].n > dp[i - 1].n) {
          minIdx = i - 1;
        } else {
          minIdx = i / 3;
        }
      } else if (i % 2 == 0) {
        if (dp[i / 2].n > dp[i - 1].n) {
          minIdx = i - 1;
        } else {
          minIdx = i / 2;
        }
      } else {
        minIdx = i - 1;
      }
      dp[i] = new Node(minIdx, dp[minIdx].n + 1);
    }
    sb.append(dp[N].n + "\n");
    int ans = N;
    while (ans >= 1) {
      sb.append(ans + " ");
      ans = dp[ans].prev;
    }
    System.out.println(sb.toString());
  }
  
}
