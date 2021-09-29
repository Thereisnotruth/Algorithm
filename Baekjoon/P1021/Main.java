package P1021;

import java.util.*;

public class Main {
    static Deque<Integer> deque1, deque2;
    static int N, M;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            deque1.addLast(i);
        }

        int answer = 0;
        
        for (int i = 0; i < M; i++) {
            int k = sc.nextInt();
            int count = 0;


            if (deque2.isEmpty()) {
                while (deque1.peekLast() != k) {
                    count++;
                    deque2.offerFirst(deque1.pollLast());
                }
                count++;
                deque1.pollLast();

                while (!deque1.isEmpty()) {
                    deque2.offerLast(deque1.pollFirst());
                }
            } else {
                while (deque2.peekLast() != k) {
                    count++;
                    deque1.offerFirst(deque2.pollLast());
                }
                count++;
                deque2.pollLast();

                while (!deque2.isEmpty()) {
                    deque1.offerLast(deque2.pollFirst());
                }
            }
            if (count > N / 2) {
                count = N - count;
            }
            N--;
            answer += count;
        }

        System.out.println(answer);
    }

}
