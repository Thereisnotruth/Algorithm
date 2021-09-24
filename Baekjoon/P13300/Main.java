package P13300;

import java.util.*;

public class Main {
    static int N, K, Y, S, rooms;
    static int[] men, women;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        men = new int[7];
        women = new int[7];

        for (int i = 0; i < N; i++) {
            S = sc.nextInt();
            Y = sc.nextInt();

            if (S == 0) {
                women[Y]++;
            } else {
                men[Y]++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (men[i] != 0) {
                if (men[i] % K == 0) {
                    rooms += men[i] / K;
                } else {
                    rooms += men[i] / K + 1;
                }
            }
            if (women[i] != 0) {
                if (women[i] % K == 0) {
                    rooms += women[i] / K;
                } else {
                    rooms += women[i] / K + 1;
                }
            }
        }

        System.out.println(rooms);
    }
}
