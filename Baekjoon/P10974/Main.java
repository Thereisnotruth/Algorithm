package P10974;

import java.util.*;

public class Main {
  static int N;
  static int[] arr, ans;
  static boolean[] visited;
  static StringBuilder sb;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    sb = new StringBuilder();

    N = sc.nextInt();

    arr = new int[N];
    ans = new int[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      arr[i] = i + 1;
    }

    dfs(0);
    System.out.println(sb.toString());
  }

  public static void dfs (int depth) {
    if (depth == N) {
      for (int i = 0; i < N; i++) {
        sb.append(ans[i] + " ");
      }
      sb.append('\n');
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        ans[depth] = arr[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
  
}
