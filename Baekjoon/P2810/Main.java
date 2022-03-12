package P2810;

import java.util.*;

public class Main {
  static int N, answer;
  static boolean couple, ch;
  static String str;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    str = sc.next();

    for (int i = 0; i < N; i++) {
      if (str.charAt(i) == 'S') {
        answer++;
      } else if (str.charAt(i) == 'L') {
        ch = true;
        if (!couple) {
          couple = true;
        } else {
          couple = false;
          answer++;
        }
      }
    }
    if (ch) {
      answer++;
    }
    System.out.println(answer);
  }
  
}
