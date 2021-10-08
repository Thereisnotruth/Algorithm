package P1260;

import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList[] graph;
    static Queue<Integer> queue;
    static boolean[] visited;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
    }
    static void BFS(int v) {
        visited[v] = true;
        queue.add(v);
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int size = graph[cur].size();
            for (int i = 0; i < size; i++) {
                int target = (int)graph[cur].get(i);
                if (visited[target]) {
                    continue;
                }
                visited[target] = true;
                queue.add(target);
                System.out.print(target + " ");
            }
        }
    }
    static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        int size = graph[v].size();
        for (int i = 0; i < size; i++) {
            int target = (int)graph[v].get(i);
            if (visited[target]) {
                continue;
            }
            DFS(target);
        }
    }
}
