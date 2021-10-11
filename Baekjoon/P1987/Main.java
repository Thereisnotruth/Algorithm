package P1987;

import java.util.*;

public class Main {
    static int R, C, answer;
    static boolean[][] visited;
    static boolean[] alpha;
    static String[] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        alpha = new boolean[26];
        visited = new boolean[R][C];
        board = new String[R];

        for (int i = 0; i < R; i++) {
            board[i] = sc.next();
        }

        DFS(0, 0, 1);

        System.out.println(answer);
    }
    static void DFS(int y, int x, int cnt) {
        visited[y][x] = true;
        alpha[board[y].charAt(x) - 'A'] = true;
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            if (visited[ny][nx] || alpha[board[ny].charAt(nx) - 'A']) {
                continue;
            }
            DFS(ny, nx, cnt + 1);
        }
        visited[y][x] = false;
        alpha[board[y].charAt(x) - 'A'] = false;
    }
}