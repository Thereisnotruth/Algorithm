package P11279;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N;
    static PriorityQueue<Integer> maxHeap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int op = Integer.parseInt(br.readLine());
            if (op == 0) {
                if (maxHeap.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(maxHeap.remove()).append("\n");
            } else {
                maxHeap.add(op);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
