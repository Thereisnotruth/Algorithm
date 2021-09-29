package P10866;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] deque;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        deque = new int[10000];

        N = Integer.parseInt(br.readLine());
        int head = 0;
        int tail = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                if (head == 0) {
                    head = 9999;
                    deque[head] = x;
                } else {
                    deque[--head] = x;
                }
            } else if (op.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque[tail++] = x;
                if (tail == 10000) {
                    tail = 0;
                }
            } else if (op.equals("pop_front")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[head++] + "\n");
                    if (head == 10000) {
                        head = 0;
                    }
                }
            } else if (op.equals("pop_back")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    if (tail == 0) {
                        tail = 9999;
                        sb.append(deque[tail] + "\n");
                    } else {
                        sb.append(deque[--tail] + "\n");
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
            } else if (op.equals("front")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque[head] + "\n");
                }
            } else if (op.equals("back")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    if (tail == 0) {
                        sb.append(deque[9999] + "\n");
                    } else {
                        sb.append(deque[tail - 1] + "\n");
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
}
