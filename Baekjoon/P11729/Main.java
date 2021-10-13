package P11729;

import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt;
    static List<Move> answer;
    static class Move {
        int from, to;
        public Move (int f, int t) {
            this.from = f;
            this.to = t;
        }
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        answer = new ArrayList<>();
        Hanoi(N, 1, 2, 3);

        sb.append(cnt + "\n");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i).from + " " + answer.get(i).to + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void Hanoi (int n, int from, int mid, int to) {
        cnt++;
        if (n == 1) {
            answer.add(new Move(from, to));
        } else {
            Hanoi(n - 1, from, to, mid);
            answer.add(new Move(from, to));
            Hanoi(n - 1, mid, from, to);
        }
    }
    
}
