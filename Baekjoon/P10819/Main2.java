package P10819;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, ans;
    static int[] A, temp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        temp = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            temp[0] = A[i];
            backtracking(1);
            visited[i] = false;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void backtracking(int level) {
        if (level == N) {
            int sum = 0;

            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            temp[level] = A[i];
            backtracking(level + 1);
            visited[i] = false;
        }
    }
}
