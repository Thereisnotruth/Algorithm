package P1103;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static int answer;
    static boolean inf;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void input () {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'H') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = str.charAt(j) - '0';
                }
            }
        }

    }
    public static void solve () {
        dfs(0, 0, 1);
    }
    public static void output() {
        if (inf) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
    public static void dfs (int y, int x, int count) {
        answer = Math.max(answer, count);
        dp[y][x] = count;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i] * board[y][x];
            int nx = x + dx[i] * board[y][x];

            if (ny < 0 || nx < 0 || nx >= M || ny >= N) {
                continue;
            }

            if (visited[ny][nx]) {
                inf = true;
                return;
            }

            if (dp[ny][nx] > count || board[ny][nx] == 0) {
                continue;
            }
            visited[ny][nx] = true;
            dfs(ny, nx, count + 1);
            visited[ny][nx] = false;
        }
    }
    public static void main (String[] args) {
        input();
        solve();
        output();
    }
}
