package p8958;

import java.io.*;
import java.util.*;

public class Main {
    static int tc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String tmp = br.readLine();
            int score = 0;
            int sum = 0;
            for (int i = 0; i < tmp.length(); i++) {
                char ch = tmp.charAt(i);
                if (ch == 'O') {
                    sum += (++score);
                } else {
                    score = 0;
                }
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
