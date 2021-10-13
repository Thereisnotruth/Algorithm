package P1629;

import java.util.*;

public class Main {
    static int A, B, C;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(Solution(A, B, C));
    }

    static long Solution (int A, int B, int C) {
       if (B == 1) {
           return A % C;
       }
       long ret = Solution(A, B / 2, C);
       ret = ret * ret % C;
       if (B % 2 == 0) {
           return ret;
       } else {
           return ret * A % C;
       }
    }
    
}
