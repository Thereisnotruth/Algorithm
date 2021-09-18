package P2490;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int num = 0;
            for(int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0")) {
                    num++;
                }
            }
            switch (num) {
                case 0:
                    sb.append("E\n");
                    break;
                case 1:
                    sb.append("A\n");
                    break;
                case 2:
                    sb.append("B\n");
                    break;
                case 3:
                    sb.append("C\n");
                    break;
                case 4:
                    sb.append("D\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
