package P11060;

import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int[] a, visited;
  static Queue<Integer> q;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    visited = new int[n];
    q = new LinkedList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      visited[i] = -1;
    }

    q.add(0);
    visited[0] = 0;

    while (!q.isEmpty()) {
      int curIdx = q.remove();
      for (int i = 0; i <= a[curIdx]; i++) {
        int nextIdx = curIdx + i;
        if (nextIdx < n && visited[nextIdx] == -1) {
          q.add(nextIdx);
          visited[nextIdx] = visited[curIdx] + 1;
        }
      }
    }
    if (visited[n - 1] == -1) {
      System.out.println(-1);
    } else {
      System.out.println(visited[n - 1]);
    }
  }
  
}
