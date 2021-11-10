package P10829;

import java.util.*;
import java.math.*;

public class Main {
    static long N;
    static StringBuilder sb;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        sb = new StringBuilder();

        binary(N);

        System.out.println(sb.reverse().toString());
    }
    static void binary(long n) {
        if (n == 0) {
            return;
        }
        sb.append(n % 2);
        binary(n / 2);
    }
}
