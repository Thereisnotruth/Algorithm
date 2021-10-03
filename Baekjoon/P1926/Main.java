package P1926;

import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> queue;
    static class Point {
        int x, y;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int maxArea = 0;
        int paintCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] == 0) {
                    continue;
                } else {
                    int count = 1;
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    paintCount++;

                    while (!queue.isEmpty()) {
                        Point curr = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = curr.x + dx[k];
                            int ny = curr.y + dy[k];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (visited[ny][nx] || board[ny][nx] != 1) {
                                continue;
                            }
                            visited[ny][nx] = true;
                            count++;
                            queue.offer(new Point(ny, nx));
                        }
                    }
                    if (maxArea < count) {
                        maxArea = count;
                    }
                }
            }
        }
        System.out.println(paintCount);
        System.out.println(maxArea);
    }
    
}
