package p4344;

import java.util.*;
import java.io.*;

public class Main {
    static int C, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }
            float average = (float) sum / N;
            int overAverage = 0;
            for (int i = 0; i < N; i++) {
                if (scores[i] > average) {
                    overAverage++;
                }
            }

            sb.append(String.format("%.3f", 100 * ((float) overAverage / N))).append("%\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
