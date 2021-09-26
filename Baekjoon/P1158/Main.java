package P1158;

import java.util.*;

public class Main {
    static int N, K;
    static Queue<Integer> queue;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        queue = new LinkedList<>();

        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int order = 0;
        sb.append("<");
        while (!queue.isEmpty()) {
            order++;
            if (order == K) {
                sb.append(queue.poll());
                order = 0;
                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                queue.offer(queue.poll());
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
        
    }
}
