package P10773;

import java.util.*;

public class Main {
    static Stack<Integer> stack;
    static int K, sum;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        stack = new Stack<>();
        K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();

            if (num != 0) {
                stack.push(num);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
    
}
