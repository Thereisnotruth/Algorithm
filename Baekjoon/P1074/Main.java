package P1074;

import java.util.*;

public class Main {
    static int N, r, c;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        System.out.println(Solution(N, r, c));
    }
    static int Solution (int N, int r, int c) {
        if (N == 0) {
            return 0;
        }
        int halfSize = 1 << (N - 1);
        if (r < halfSize && c < halfSize) {
            return Solution(N - 1, r, c);
        } else if (r < halfSize && c >= halfSize) {
            return halfSize * halfSize + Solution(N - 1, r, c - halfSize);
        } else if (r >= halfSize && c < halfSize) {
            return 2 * halfSize * halfSize + Solution(N - 1, r - halfSize, c);
        } else {
            return 3 * halfSize * halfSize + Solution(N - 1, r - halfSize, c - halfSize);
        }
        
    }
    
}
