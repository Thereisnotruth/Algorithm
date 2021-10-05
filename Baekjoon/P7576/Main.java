package P7576;

import java.util.*;

public class Main {
    static int N, M, days, tomatos, spaces;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Point {
        int y, x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        

        board = new int[N][M];
        visited = new boolean[N][M];
        spaces = N * M;
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    tomatos++;
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
                if (tmp == -1) {
                    spaces--;
                }
                board[i][j] = tmp;
            }
        }
        days = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (board[ny][nx] != 0 || visited[ny][nx]) {
                    continue;
                }
                tomatos++;
                queue.offer(new Point(ny, nx));
                visited[ny][nx] = true;
                board[ny][nx] = board[cur.y][cur.x] + 1;

                if (days < board[ny][nx]) {
                    days = board[ny][nx];
                }
            }

        }
        days--;


        if (spaces == tomatos) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
    
}
