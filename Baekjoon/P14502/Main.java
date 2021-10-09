package P14502;

import java.util.*;

public class Main {
    static int N, M;
    static int spaces, answer;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Point> queue;
    static int[][] board;
    static boolean[][] visited;

    static class Point {
        int y, x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        queue = new LinkedList<>();
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int in = sc.nextInt();
                if (in == 0) {
                    spaces++;
                }
                board[i][j] = in;
            }
        }
        setWall(0);
        
        System.out.println(answer);
    }
    static void virus () {
        int cnt = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.remove();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (visited[ny][nx] || board[ny][nx] != 0) {
                    continue;
                }
                cnt++;
                visited[ny][nx] = true;
                queue.add(new Point(ny, nx));
            }
        }
        answer = Math.max(answer, spaces - cnt);
    }
    static void setWall (int cnt) {
        if (cnt == 3) {
            virus();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    spaces--;
                    setWall(cnt + 1);
                    board[i][j] = 0;
                    spaces++;
                }
            }
        }
    }
}
