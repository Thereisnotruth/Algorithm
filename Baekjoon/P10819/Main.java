package P10819;

import java.util.*;

public class Main {
  static int N, ans;
  static int[] arr, arr2;
  static boolean[] visited;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N  = sc.nextInt();

    arr = new int[N];
    arr2 = new int[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      visited[i] = true;
      arr2[0] = arr[i];
      dfs(1);
      visited[i] = false;
    }

    System.out.println(ans);
  }
  public static int diff () {
    int ret = 0;
    for (int i = 0; i < N - 1; i++) {
      ret += Math.abs(arr2[i] - arr2[i + 1]);
    }
    return ret;
  }

  public static void dfs (int cnt) {
    if (cnt == N) {
      ans = Math.max(ans, diff());
      return;
    }
    for (int i = 0; i < N; i++) {
      if (visited[i]) {
        continue;
      }
      arr2[cnt] = arr[i];
      visited[i] = true;
      dfs(cnt + 1);
      visited[i] = false;
    }
  }
}
