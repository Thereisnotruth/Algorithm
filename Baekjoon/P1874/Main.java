package P1874;

import java.util.*;

public class Main {
    static Stack<Integer> stack;
    static List<Integer> list;
    static int N;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();

        stack = new Stack<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }

        int idx1 = 1;
        int idx2 = 0;
        while (idx2 < N) {
            if (stack.isEmpty() || !stack.peek().equals(list.get(idx2))) {
                if (!stack.isEmpty()) {
                    System.out.println("equals : " + stack.peek().equals(list.get(idx2)));
                    System.out.println("== : " + (stack.peek() == list.get(idx2)));
                }
                
                if (idx1 > N) {
                    sb = new StringBuilder("NO");
                    break;
                }
                stack.push(idx1);
                idx1++;
                sb.append("+\n");
            } else {
                stack.pop();
                sb.append("-\n");
                idx2++;
            }
        }
        System.out.print(sb.toString());
    }
    
}
