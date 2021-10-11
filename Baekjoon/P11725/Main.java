package P11725;

import java.util.*;

public class Main {
    static int N;
    static ArrayList[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            graph[a].add(b);
            graph[b].add(a);
        }
        DFS(1, 1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    static void DFS (int n, int p) {
        if (visited[n]) {
            return;
        }
        parent[n] = p;
        visited[n] = true;
        int length = graph[n].size();
        for (int i = 0; i < length; i++) {
            int cur = (int)graph[n].get(i);
            DFS(cur, n);
        }
        visited[n] = false;
    }
    
}
