package P2448;

import java.util.*;

public class Main {
    static int N, M;
    static char[][] star;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();

        star = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        Star(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
    static void Star (int y, int x, int size) {
        if (size == 3) {
            star[y][x] = '*';
            star[y + 1][x - 1] = star[y + 1][x + 1] = '*';
            star[y + 2][x - 2] = star [y + 2][x - 1] = star[y + 2][x] = star[y + 2][x + 1] = star[y + 2][x + 2] = '*';
        } else {
            int minSize = size / 2;
            Star(y, x, minSize);
            Star(y + minSize, x - minSize, minSize);
            Star(y + minSize, x + minSize, minSize);
        }
    }
}