package P7569;

import java.util.*;

public class Main {
    static int M, N, H, spaces;
    static int[][][] box;
    static int[][][] dist;
    static Queue<Point> queue;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    static class Point {
        int y, x, z;
        public Point (int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[N][M][H];
        dist = new int[N][M][H];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[j][k][i] = sc.nextInt();
                    if (box[j][k][i] == 1) {
                        queue.add(new Point(j, k, i));
                    } else if (box[j][k][i] == 0) {
                        dist[j][k][i] = -1;
                    }
                }
            }
        }
    }

    public static void solve () {
        BFS();
    }

    public static void BFS () {
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) {
                    continue;
                }
                if (box[ny][nx][nz] == -1 || dist[ny][nx][nz] >= 0) {
                    continue;
                }
                dist[ny][nx][nz] = dist[cur.y][cur.x][cur.z] + 1;
                queue.add(new Point(ny, nx, nz));
            }
        }
    }

    public static void output () {
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (dist[j][k][i] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dist[j][k][i]);
                }
            }
        }
        System.out.println(answer);
    }
    public static void main (String[] args) {
        input();
        solve();
        output();
    }
}
