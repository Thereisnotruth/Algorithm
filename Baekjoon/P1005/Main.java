package P1005;

import java.util.*;
import java.io.*;

public class Main {
  static int T, N, K, W;
  static int[] delays, dp, pre;
  static ArrayList[] graph;
  static boolean[] visited;
  static Queue<Integer> queue;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      queue = new LinkedList<>();

      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      dp = new int[N + 1];
      pre = new int[N + 1];
      delays = new int[N + 1];
      graph = new ArrayList[N + 1];
      for (int j = 1; j <= N; j++) {
        graph[j] = new ArrayList<Integer>();
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        delays[j] = Integer.parseInt(st.nextToken());
      }

      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        pre[end]++;

        graph[start].add(end);
      }

      W = Integer.parseInt(br.readLine());

      for (int j = 1; j <= N; j++) {
        if (pre[j] == 0) {
          dp[j] = delays[j];
          queue.add(j);
        }
      }

      while (!queue.isEmpty()) {
        int cur = queue.remove();
        for (int j = 0; j < graph[cur].size(); j++) {
          int next = (int)graph[cur].get(j);
          dp[next] = Math.max(dp[next], delays[next] + dp[cur]);
          if (--pre[next] == 0) {
            queue.add(next);
          }
        }
      }
      sb.append(dp[W] + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close(); bw.close();
  }
}
