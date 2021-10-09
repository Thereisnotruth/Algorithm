package P7562;

import java.util.*;

public class Main {
    static int T, N, startX, startY, endX, endY;
    static Queue<Point> queue;
    static int[][] board;
    static int[][] dist;
    static int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static class Point {
        int y, x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            board = new int[N][N];
            dist = new int[N][N];
            queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = -1;
                }
            }
            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();
            dist[startY][startX] = 0;
            queue.add(new Point(startY, startX));

            while (!queue.isEmpty()) {
                Point cur = queue.remove();
                if (cur.y == endY && cur.x == endX) {
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        continue;
                    }
                    if (dist[ny][nx] >= 0) {
                        continue;
                    }
                    dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    queue.add(new Point(ny, nx));
                }
            }
            System.out.println(dist[endY][endX]);
        }
    }
    
}
