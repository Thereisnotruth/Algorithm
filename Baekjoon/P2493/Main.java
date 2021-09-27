package P2493;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Stack<Pair> stack;
    static int[] answer;

    static class Pair {
        int height, index;
        public Pair (int h, int i) {
            this.height = h;
            this.index = i;
        }
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        stack = new Stack<>();
        stack.push(new Pair(100000001, 0));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (stack.peek().height < h) {
                stack.pop();
            }
            sb.append(stack.peek().index + " ");
            stack.push(new Pair(h, i));
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
}
