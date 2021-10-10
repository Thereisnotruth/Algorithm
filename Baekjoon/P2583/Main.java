package P2583;

import java.util.*;

public class Main {
    static int M, N, K, cnt;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Point> queue;
    static List<Integer> answer;
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
        K = sc.nextInt();

        board = new int[M][N];
        visited = new boolean[M][N];
        queue = new LinkedList<>();
        answer = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    board[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    cnt++;
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    int area = 0;
                    while (!queue.isEmpty()) {
                        Point cur = queue.remove();
                        area++;

                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                                continue;
                            }
                            if (visited[ny][nx] || board[ny][nx] == 1) {
                                continue;
                            }
                            visited[ny][nx] = true;
                            queue.add(new Point(ny, nx));
                        }
                    }
                    answer.add(area);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(cnt);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
   }

}
