package P1629;

import java.io.*;
import java.util.*;

public class Main2 {
    static int A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solve(A, B, C)));
        bw.flush();
        br.close();
        bw.close();
    }

    static long solve(int a, int b, int c) {
        if (b == 1)
            return a % c;

        long ret = solve(a, b / 2, c);
        ret = ret * ret % c;

        if (b % 2 == 0) {
            return ret;
        }
        return ret * A % c;
    }
}
