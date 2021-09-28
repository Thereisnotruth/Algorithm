package P2164;

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Queue<Integer> queue;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();

        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            if (count == 0) {
                queue.poll();
                count = 1;
            } else {
                queue.offer(queue.poll());
                count = 0;
            }
        }
        System.out.println(queue.poll());
    }

}