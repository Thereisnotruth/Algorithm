package p1181;

import java.io.*;
import java.util.*;

public class Main {
    static String[] array;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        array = new String[N];

        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1Length = s1.length();
                int s2Length = s2.length();
                if (s1Length == s2Length) {
                    return s1.compareTo(s2);
                }
                return s1Length - s2Length;
            }
        });

        String prev = "";
        for (int i = 0; i < N; i++) {
            if (prev.compareTo(array[i]) == 0) {
                prev = array[i];
                continue;
            }
            prev = array[i];
            sb.append(array[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
