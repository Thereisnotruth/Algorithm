package P2493;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N;
    static Stack<Pair> stack;

    static class Pair {
        int height, location;

        public Pair(int height, int location) {
            this.height = height;
            this.location = location;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        stack = new Stack<>();
        stack.push(new Pair(100000001, 0));

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (stack.peek().height < height) {
                stack.pop();
            }

            sb.append(stack.peek().location).append(" ");
            stack.push(new Pair(height, i));
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
