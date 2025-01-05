package p10871;

import java.util.*;
import java.io.*;

public class Main {
    static int N, X;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (next < X) {
                sb.append(next).append(" ");
            }
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
