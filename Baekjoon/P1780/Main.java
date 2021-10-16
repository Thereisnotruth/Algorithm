package P1780;

import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] answer;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];
        answer = new int[3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        Solution(N, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }
    static void Solution (int size, int y, int x) {
        int paper = board[y][x];
        boolean isPaper = true;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != paper) {
                    isPaper = false;
                    break;
                }
            }
            if (!isPaper) {
                break;
            }
        }
        if (isPaper) {
            answer[paper + 1]++;
        } else {
            int minSize = size / 3;
            Solution(minSize, y, x);
            Solution(minSize, y, x + minSize);
            Solution(minSize, y, x + 2 * minSize);
            Solution(minSize, y + minSize, x);
            Solution(minSize, y + minSize, x + minSize);
            Solution(minSize, y + minSize, x + 2 * minSize);
            Solution(minSize, y + 2 * minSize, x);
            Solution(minSize, y + 2 * minSize, x + minSize);
            Solution(minSize, y + 2 * minSize, x + 2 * minSize);
        }
    }
}
