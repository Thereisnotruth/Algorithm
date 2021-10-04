package P2178;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] dp;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static Queue<Point> queue;
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
        board = new int[N][M];
        dp = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        dp[0][0] = 1;
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (dp[ny][nx] != 0 || board[ny][nx] == 0) {
                    continue;
                }
                dp[ny][nx] = dp[curr.y][curr.x] + 1;
                queue.offer(new Point(ny, nx));
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
    
}
