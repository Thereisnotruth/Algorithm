package P1406;

import java.util.*;
import java.io.*;

public class Main {
    static Stack<Character> left, right;
    static String str;
    static int N;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        left = new Stack<>();
        right = new Stack<>();

        str = br.readLine();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken().charAt(0)) {
                case 'L':
                    if (!left.empty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if (!right.empty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (!left.empty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }

        while (!left.empty()) {
            right.push(left.pop());
        }

        while (!right.empty()) {
            sb.append(right.pop());
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
