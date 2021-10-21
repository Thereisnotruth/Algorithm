package P6603;

import java.util.*;

public class Main {
    static int[] num, lotto;
    static int k;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) {
                break;
            }
            num = new int[13];
            lotto = new int[13];
            for (int i = 0; i < k; i++) {
                lotto[i] = sc.nextInt();
            }
            DFS(0, 0);
            System.out.println();
        }
    }
    static void DFS (int n, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = n; i < k; i++) {
            num[cnt] = lotto[i];
            DFS(i + 1, cnt + 1);
        }
    }
}
