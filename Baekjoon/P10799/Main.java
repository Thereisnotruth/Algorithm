package P10799;

import java.util.*;

public class Main {
    static char prev;
    static int answer;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
                
            } else {
                stack.pop();
                if (prev == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
            prev = now;
        }
        System.out.println(answer);
    }
    
}
