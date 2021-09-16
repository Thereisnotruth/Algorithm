package P10869;

import java.util.*;
import java.io.*;

public class Main {
    static int A, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        sb.append(A + B + "\n");
        sb.append(A - B + "\n");
        sb.append(A * B + "\n");
        sb.append(A / B + "\n");
        sb.append(A % B + "\n");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
