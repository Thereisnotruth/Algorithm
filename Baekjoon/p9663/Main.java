package p9663;

import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1];

        setQueen(1);

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void setQueen(int n) {
        if (n > N) {
            ans++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            board[n] = i;

            if (isPossible(n)) {
                setQueen(n + 1);
            }
        }
    }

    public static boolean isPossible(int column) {
        for (int i = 1; i < column; i++) {
            if (board[column] == board[i]) {
                return false;
            }
            if (Math.abs(column - i) == Math.abs(board[column] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
