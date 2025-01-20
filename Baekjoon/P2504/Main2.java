package P2504;

import java.io.*;
import java.util.*;

public class Main2 {
    static int ans;
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stack = new Stack<>();
        String str = br.readLine();

        int tmp = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                tmp *= 2;
                stack.push(ch);
            }
            if (ch == '[') {
                tmp *= 3;
                stack.push(ch);
            }
            if (ch == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    ans = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    ans += tmp;
                }
                stack.pop();
                tmp /= 2;
            }
            if (ch == ']') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    ans = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    ans += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        if (!stack.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(ans));
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
