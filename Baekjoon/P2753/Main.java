package P2753;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());

        bw.write(((((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? 1 : 0) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
