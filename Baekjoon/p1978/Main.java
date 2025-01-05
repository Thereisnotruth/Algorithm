package p1978;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isPrime = new boolean[1001];
        isPrime[2] = isPrime[3] = true;
        for (int i = 4; i <= 1000; i++) {
            isPrime[i] = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime[i] = false;
                    break;
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int ans = 0;

        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());

            if (isPrime[cur])
                ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
