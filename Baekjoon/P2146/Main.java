package P2146;

import java.util.*;

public class Main {
    static int N;
    static Queue<Point> queue;
    static int[][] board;
    static int[][] group;
    static int[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int minDis = 987654321;

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

        board = new int[N][N];
        group = new int[N][N];
        visited = new int[N][N];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int groupNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && group[i][j] == 0) {
                    group[i][j] = ++groupNum;
                    queue.offer(new Point(i, j));

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();
                        
                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                                continue;
                            }
                            if (group[ny][nx] != 0 || board[ny][nx] != 1) {
                                continue;
                            }

                            group[ny][nx] = groupNum;
                            queue.offer(new Point(ny, nx));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                if (visited[ny][nx] != -1) {
                    continue;
                }
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                group[ny][nx] = group[cur.y][cur.x];
                queue.offer(new Point(ny, nx));
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        continue;
                    }
                    if (group[i][j] != group[ny][nx]) {
                        minDis = Math.min(minDis, visited[i][j] + visited[ny][nx]);
                    }
                }
            }
        }
        System.out.println(minDis);
    }
}