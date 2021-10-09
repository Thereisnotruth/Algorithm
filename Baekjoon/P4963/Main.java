package P4963;

import java.util.*;

public class Main {
    static int W, H;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1 ,0, 1};
    static int cnt;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            W = sc.nextInt();
            H = sc.nextInt();
            if (W == 0 && H == 0) {
                break;
            }
            board = new int[H][W];
            visited = new boolean[H][W];
            cnt = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        DFS(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void DFS (int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
                continue;
            }
            if (visited[ny][nx] || board[ny][nx] != 1) {
                continue;
            }
            DFS(ny, nx);
        }
    }
}

