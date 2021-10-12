package P2206;

import java.util.*;

public class Main {
    static int N, M, answer = 987654321;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board;
    static int[][] visited;
    static Queue<Point> queue;
    static class Point {
        int y, x, distance, drill;
        public Point (int y, int x, int distance, int drill) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.drill = drill;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        visited = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - '0';
                visited[i][j] = 987654321;
            }
        }
        BFS(0, 0);
        if (answer != 987654321) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
        
    }
    static void BFS(int y, int x) {
        visited[y][x] = 0;
        queue.add(new Point(y, x, 1, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            if (cur.y == N - 1 && cur.x == M - 1) {
                answer = cur.distance;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (visited[ny][nx] <= cur.drill) {
                    continue;
                }
                if (board[ny][nx] == 0) {
                    visited[ny][nx] = cur.drill;
                    queue.add(new Point(ny, nx, cur.distance + 1, cur.drill));
                } else {
                    if (cur.drill == 0) {
                        visited[ny][nx] = cur.drill + 1;
                        queue.add(new Point(ny, nx, cur.distance + 1, cur.drill + 1));
                    }
                }
            }
        }
    }
}
