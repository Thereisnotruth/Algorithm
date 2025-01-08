package P9012;

import java.io.*;
import java.util.*;

public class Main2 {
    static int T;
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            stack = new Stack<>();
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }

                char top = stack.peek();

                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (top == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
