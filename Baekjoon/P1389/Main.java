package P1389;

import java.util.*;
import java.io.*;

public class Main {
  static class Edge {
    int a, b;
    public Edge (int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
  static ArrayList[] graph;
  static int n, m, answer = 1;
  static int[] visited, kevin;
  static Queue<Integer> queue;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    kevin = new int[n + 1];
    queue = new LinkedList<>();
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= n; i++) {
      visited = new int[n + 1];
      queue.add(i);

      while (!queue.isEmpty()) {
        int cur = queue.remove();
        for (int j = 0; j < graph[cur].size(); j++) {
          int next = (int)graph[cur].get(j);
          if (visited[next] == 0 && next != i) {
            visited[next] = visited[cur] + 1;
            queue.add(next);
          }
        }
      }
      for (int j = 1; j <= n; j++) {
        kevin[i] += visited[j];
      }
    }
    
    for (int i = 2; i <= n; i++) {
      if (kevin[answer] > kevin[i]) {
        answer = i;
      }
    }

    System.out.println(answer);
  }
}
