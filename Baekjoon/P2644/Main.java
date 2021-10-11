package P2644;

import java.util.*;

public class Main {
    static int n, manA, manB, m, answer = -1;
    static boolean[] visited;
    static ArrayList[] graph;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        manA = sc.nextInt();
        manB = sc.nextInt();

        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        DFS(manA, 0);
        System.out.println(answer);
    }
    static void DFS (int node, int cnt) {
        if (node == manB) {
            answer = cnt;
            return;
        }
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        int length = graph[node].size();

        for (int i = 0; i < length; i++) {
            int cur = (int)graph[node].get(i);
            DFS(cur, cnt + 1);
        }
        visited[node] = false;
    }
    
}
