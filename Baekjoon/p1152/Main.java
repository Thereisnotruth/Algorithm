package p1152;

import java.io.*;
import java.util.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            st.nextToken();
            answer++;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

}
