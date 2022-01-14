package P1065;

import java.util.*;

public class Main {
  static int n, answer;
  static boolean[] oneNum;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    oneNum = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      oneNum[i] = Check(String.valueOf(i));
    }

    for (int i = 1; i <= n; i++) {
      if (oneNum[i]) {
        answer++;
      }
    }
    System.out.println(answer);
  }
  static boolean Check (String num) {
    int prev = num.charAt(0);
    int cur, diff;
    if (num.length() > 1) {
      cur = num.charAt(1);
      diff = cur - prev;
      for (int i = 2; i < num.length(); i++) {
        prev = cur;
        cur = num.charAt(i);
        if (diff != cur - prev) {
          return false;
        }
      }
    }
    return true;
  }
  
}
