package p2750;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);
        for (int i = 0; i < N; i++) {
            sb.append(array[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

}
