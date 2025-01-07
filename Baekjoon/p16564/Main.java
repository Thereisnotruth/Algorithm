package p16564;

import java.util.*;
import java.io.*;

public class Main {
    static int N, K, ans;
    static int[] X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        X = new int[N];

        int start = 1000000001;
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, X[i]);
        }
        int end = start + K;
        while (start <= end) {
            int mid = (start + end) / 2;

            long level = levelup(mid);

            if (level <= K) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    static long levelup(long level) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (level > X[i]) {
                sum += (level - X[i]);
            }
        }

        return sum;
    }
}
