package P10026;

import java.util.*;

public class Main {
    static int N, answerA, answerB;
    static char[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Point> queue;

    static class Point {
        int y, x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void input () {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        board = new char[N][N];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }
    }
    public static int solve (boolean CB) {
        visited = new boolean[N][N];
        if (CB) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'R') {
                        board[i][j] = 'G';
                    }
                }
            }
        }
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                    area++;

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                                continue;
                            }
                            if (board[ny][nx] != board[i][j] || visited[ny][nx]) {
                                continue;
                            }
                            visited[ny][nx] = true;
                            queue.offer(new Point(ny, nx));
                        }
                    }

                }
            }
        }
        return area;
    }
    public static void output() {
        System.out.println(answerA + " " + answerB);
    }
    public static void main (String[] args) {
        input();
        answerA = solve(false);
        answerB = solve(true);
        output();
    }
    
}
