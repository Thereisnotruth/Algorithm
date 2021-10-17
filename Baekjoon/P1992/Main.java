package P1992;

import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String st = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = st.charAt(j) - '0';
            }
        }
        Solution(N, 0, 0);
    }
    static void Solution (int size, int y, int x) {
        int num = board[y][x];
        boolean isSame = true;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != num) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }
        if (isSame) {
            System.out.print(num);
        } else {
            int minSize = size / 2;
            System.out.print("(");
            Solution(minSize, y, x);
            Solution(minSize, y, x + minSize);
            Solution(minSize, y + minSize, x);
            Solution(minSize, y + minSize, x + minSize);
            System.out.print(")");
        }
    }
}
