package p2805;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(trees[i], maxHeight);
        }

        binarySearch(0, maxHeight);

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    static long cut(int height) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (height < trees[i]) {
                sum += (trees[i] - height);
            }
        }
        return sum;
    }

    static void binarySearch(int start, int end) {
        if (start > end) {
            return;
        }

        int middle = (start + end) / 2;
        long tree = cut(middle);

        if (tree < M) {
            binarySearch(start, middle - 1);
        } else if (tree > M) {
            ans = middle;
            binarySearch(middle + 1, end);
        } else {
            ans = middle;
        }
    }
}
