package P6198;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long sum;
    static List<Integer> list;
    static Stack<Building> stack;
    static class Building {
        int h, n;
        public Building(int h, int n) {
            this.h = h;
            this.n = n;
        }
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        stack = new Stack<>();
        stack.push(new Building(1000000001, 0));

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = N - 1; i >= 0; i--) {
            int now = list.get(i);
            int see = 0;
            while (stack.peek().h < now) {
                see += stack.pop().n;
                see++;
            }
            sum += see;
            stack.push(new Building(now, see));
        }
        
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }    
}
