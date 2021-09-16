package P2752;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        for(int i = 0; i < 3; i++) {
            sb.append(list.get(i) + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
