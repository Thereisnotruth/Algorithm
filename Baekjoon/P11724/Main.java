package P11724;

import java.util.*;

public class Main {
    static int N, M, answer;
    static Queue<Integer> queue;
    static boolean[] visited;
    static ArrayList[] edges;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a].add(b);
            edges[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            answer++;
            BFS(i);
        }
        System.out.println(answer);
    }
    static void DFS (int v) {
        visited[v] = true;
        int length = edges[v].size();
        for (int i = 0; i < length; i++) {
            int cur = (int)edges[v].get(i);
            if (visited[cur]) {
                continue;
            }
            DFS(cur);
        }
    }
    static void BFS (int v) {
        queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int length = edges[cur].size();

            for (int i = 0; i < length; i++) {
                int nCur = (int)edges[cur].get(i);
                if (visited[nCur]) {
                    continue;
                }
                visited[nCur] = true;
                queue.add(nCur);
            }
        }
    }
}
