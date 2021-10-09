package P2468;

import java.util.*;

public class Main {
    static int N, answer;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int rain = 0; rain <= 100; rain++) {
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] <= rain && !visited[i][j]) {
                        DFS(i, j, rain);
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        cnt++;
                        DFS(i, j, 101);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
    static void DFS (int y, int x, int rain) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                continue;
            }
            if (visited[ny][nx] || board[ny][nx] > rain) {
                continue;
            }
            DFS(ny, nx, rain);
        }
    }
    
}
