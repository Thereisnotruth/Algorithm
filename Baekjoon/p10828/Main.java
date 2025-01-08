package p10828;

import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        stack = new Stack<>();

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            int X = 0;
            if (op.compareTo("push") == 0) {
                X = Integer.parseInt(st.nextToken());
            }
            doSomething(op, X);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void doSomething(String op, int X) {
        switch (op) {
            case "push":
                stack.push(X);
                break;
            case "pop":
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(String.valueOf(stack.pop())).append("\n");
                }
                break;
            case "size":
                sb.append(String.valueOf(stack.size())).append("\n");
                break;
            case "empty":
                if (stack.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                break;
            case "top":
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(String.valueOf(stack.peek())).append("\n");
                }
                break;
        }
    }
}
