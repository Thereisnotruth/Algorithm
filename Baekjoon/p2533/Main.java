package p2533;

import java.util.*;
import java.io.*;

public class Main {
  static int N, maxLevel;
  static List[] graph;
  static int[][] dp;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    visited = new boolean[N + 1];
    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<Integer>();
    }
    dp = new int[N + 1][2];
    // 이 노드가 얼리어답터일 때 - 1, 얼리어답터가 아닐 때 - 0, 조건을 만족하는 얼리어답토 최소 수
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    dfs(1);

    bw.write(Math.min(dp[1][0], dp[1][1]) + "\n");
    bw.flush();
    br.close();
    bw.close();
  }

  static void dfs(int cur) {
    visited[cur] = true;
    dp[cur][1] = 1;
    for (int i = 0; i < graph[cur].size(); i++) {
      int child = (int) graph[cur].get(i);
      if (!visited[child]) {
        dfs(child);
        dp[cur][0] += dp[child][1];
        dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
      }
    }
  }
}
