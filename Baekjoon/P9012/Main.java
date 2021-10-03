package P9012;

import java.util.*;

public class Main {
    static Stack<Character> stack;
    static int N;
    static String str;
    static boolean correct;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            stack = new Stack<>();
            str = sc.next();
            correct = true;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else if (str.charAt(j) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        correct = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!correct || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
    
}
