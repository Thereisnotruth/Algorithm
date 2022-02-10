package P13305;

import java.util.*;

public class Main {
  static int N;
  static long cost, ans;
  static int[] costs, dist;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    costs = new int[N];
    dist = new int[N - 1];

    for (int i = 0; i < N - 1; i++) {
      dist[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      costs[i] = sc.nextInt();
    }

    cost = costs[0];
    ans = cost * dist[0];

    for (int i = 1; i < N - 1; i++) {
      if (cost < costs[i]) {
        ans += cost * dist[i];
      } else {
        cost = costs[i];
        ans += cost * dist[i];
      }
    }
    System.out.println(ans);
  }
  
}
