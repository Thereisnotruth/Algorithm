package P1439;

import java.util.*;

public class Main {
  static String input;
  static int[] cnt;
  static char before;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    input = sc.next();

    cnt = new int[2];
    before = input.charAt(0);
    cnt[before - '0']++;

    for (int i = 1; i < input.length(); i++) {
      char cur = input.charAt(i);
      if (cur != before) {
        cnt[cur - '0']++;
        before = cur;
      }
    }
    System.out.println(Math.min(cnt[0], cnt[1]));
  }
  
}
