package P10845;

import java.util.*;
import java.io.*;

public class Main {
    static int[] queue;
    static int N;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        queue = new int[10000];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                queue[tail++] = n;
                if (tail == 10000) {
                    tail = 0;
                }
            } else if (op.equals("front")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue[head] + "\n");
                }
            } else if (op.equals("back")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    if (tail == 0) {
                       sb.append(queue[9999] + "\n");
                    } else {
                        sb.append(queue[tail - 1] + "\n");
                    }
                }
            } else if (op.equals("size")) {
                int size = tail - head;
                if (size >= 0) {
                    sb.append(size + "\n");
                } else {
                    sb.append((10000 + size) + "\n");
                }
            } else if (op.equals("empty")) {
                if (head == tail) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (op.equals("pop")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue[head] + "\n");
                    if (head == 9999) {
                        head = 0;
                    } else {
                        head++;
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
}
