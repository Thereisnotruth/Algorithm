package P2606;

import java.util.*;

public class Main {
    static int N, M, answer = -1;
    static ArrayList[] edges;
    static boolean[] visited;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a].add(b);
            edges[b].add(a);
        }
        DFS(1);
        System.out.println(answer);
    }

    static void DFS (int v) {
        visited[v] = true;
        answer++;
        int length = edges[v].size();

        for (int i = 0; i < length; i++) {
            if (visited[(int)edges[v].get(i)]) {
                continue;
            }
            DFS((int)edges[v].get(i));
        }
    }
}
