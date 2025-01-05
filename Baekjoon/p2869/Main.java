package p2869;

import java.io.*;
import java.util.*;

public class Main {
    static int A, B, V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        int tmp = (V - B) % (A - B);
        int day = (V - B) / (A - B);

        if (tmp != 0)
            day++;

        bw.write(String.valueOf(day));
        bw.flush();
        br.close();
        bw.close();
    }
}
