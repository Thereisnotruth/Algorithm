package P2164;

import java.util.*;
import java.io.*;

public class Main3 {
    static int N;
    static Queue<Integer> queue;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            if (!flag) {
                queue.remove();
            } else {
                queue.add(queue.remove());
            }
            flag = !flag;
        }

        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        br.close();
        bw.close();
    }
}
