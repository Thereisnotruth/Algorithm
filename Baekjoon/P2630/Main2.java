package P2630;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N, white, blue;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        sb.append(white).append("\n");
        sb.append(blue).append("\n");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void solve(int y, int x, int size) {
        boolean isSameColor = true;
        int color = board[y][x];
        out: for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != board[i][j]) {
                    isSameColor = false;
                    break out;
                }
            }
        }

        if (isSameColor) {
            if (color == 0)
                white++;
            else
                blue++;
        } else {
            int halfSize = size / 2;
            solve(y, x, halfSize);
            solve(y, x + halfSize, halfSize);
            solve(y + halfSize, x, halfSize);
            solve(y + halfSize, x + halfSize, halfSize);
        }
    }
}
