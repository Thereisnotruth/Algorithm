package P4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            boolean balance = true;
            Stack<Character> stack = new Stack<>();
            if (str.equals(".")) {
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                }
                if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        balance = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        balance = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                balance = false;
            }
            if (balance) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
