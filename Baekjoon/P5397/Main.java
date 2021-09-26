package P5397;

import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static Stack<Character> left, right;
    static String str;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        left = new Stack<>();
        right = new Stack<>();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (str.charAt(j) == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (str.charAt(j) == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(str.charAt(j));
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
