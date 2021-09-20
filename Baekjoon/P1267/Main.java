package P1267;

import java.util.*;

public class Main {
    static List<Integer> list;
    static int N, Y, M;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            int tmp = list.get(i);
            Y += (tmp / 30 + 1) * 10;
            M += (tmp / 60 + 1) * 15;
        }

        if (Y > M) {
            System.out.println("M " + M);
        } else if (Y < M) {
            System.out.println("Y " + Y);
        } else {
            System.out.println("Y M " + Y);
        }
    }
    
}
