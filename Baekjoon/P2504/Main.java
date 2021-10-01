package P2504;

import java.util.*;

public class Main {
    static long answer, tmp;
    static Stack<Character> stack;
    static boolean correct;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        stack = new Stack<>();
        correct = true;
        tmp = 1;

        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
                tmp *= 2;
            } else if (now == '[') {
                stack.push(now);
                tmp *= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    correct = false;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    correct = false;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        if (correct && stack.isEmpty()) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }

}