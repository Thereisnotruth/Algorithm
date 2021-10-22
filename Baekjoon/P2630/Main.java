package P2630;

import java.util.*;

public class Main {
    static int N, blue, white;
    static int[][] board;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        DFS(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void DFS(int y, int x, int size) {
        int color = board[y][x];
        boolean sameColor = true;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != board[i][j]) {
                    sameColor = false;
                    break;
                }
            }
            if (!sameColor) {
                break;
            }
        }
        if (sameColor) {
            if (color == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            int cut = size / 2;
            DFS(y, x, cut);
            DFS(y, x + cut, cut);
            DFS(y + cut, x, cut);
            DFS(y + cut, x + cut, cut);
        }
    }
}
