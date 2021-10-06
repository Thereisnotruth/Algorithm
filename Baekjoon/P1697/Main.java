package P1697;

import java.util.*;

public class Main {
    static int[] arr;
    static int[] visited;
    static Queue<Integer> queue;
    static int N, K;
    static int[] move = { -1, 1, 2 };
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        visited = new int[100_001];
        queue = new LinkedList<>();

        for (int i = 0; i <= 100000; i++) {
            visited[i] = -1;
        }
        visited[N] = 0;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nd;
                if (i == 2) {
                    nd = cur * move[i];
                } else {
                    nd = cur + move[i];
                }
                if (nd < 0 || nd > 100000) {
                    continue;
                }
                if (visited[nd] >= 0) {
                    continue;
                }
                visited[nd] = visited[cur] + 1;
                queue.offer(nd);
            }
        }
        System.out.println(visited[K]);
    }
    
}
