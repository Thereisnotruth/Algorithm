package P11866;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N, K;
    static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        queue = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.remove();
            count++;

            if (count == K) {
                sb.append(current).append(", ");
                count = 0;
            } else {
                queue.add(current);
            }
        }

        sb.replace(sb.length() - 2, sb.length(), "");

        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
