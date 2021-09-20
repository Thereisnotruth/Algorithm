package P2577;

import java.util.*;

public class Main {
    static int A, B, C;
    static int[] num;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        num = new int[10];
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        String mul = String.valueOf((long)A * B * C);
        
        for(int i = 0; i < mul.length(); i++) {
            num[Integer.parseInt(mul.substring(i, i + 1))]++;
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(num[i]);
        }

    }
}
