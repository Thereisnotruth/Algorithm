package P2447;

import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star(i, j, N);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    static void star (int i, int j, int N) {
        if ((i / N) % 3 == 1 && (j / N) % 3 == 1) {
            sb.append(" ");
        } else {
            if (N / 3 == 0) {
                sb.append("*");
            } else {
                star(i, j, N / 3);
            }
        }
    }
    
}
