package P5430;

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> deque;
    static int T;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            deque = new LinkedList<>();
            boolean reverse = false;
            boolean error = false;
            String p = br.readLine();
            br.readLine();
            st =  new StringTokenizer(br.readLine().replaceAll("[\\[\\]]", "").replaceAll("[,]", " "));
            while (st.hasMoreTokens()) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }
            int pLength = p.length();
            for (int j = 0; j < pLength; j++) {
                if (p.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (reverse) {
                        while (!deque.isEmpty()) {
                            sb.append(deque.pollLast() + ",");
                        }
                    } else {
                        while (!deque.isEmpty()) {
                            sb.append(deque.pollFirst() + ",");
                        }
                    }
                    sb.deleteCharAt(sb.lastIndexOf(","));
                }
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    
}
