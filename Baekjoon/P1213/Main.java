package P1213;

import java.util.*;

public class Main {
  static String enName;
  static int[] alphabet;
  static char[] ans;
  static int check, idx, len;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    enName = sc.next();

    len = enName.length();
    alphabet = new int[26];
    ans = new char[enName.length()];

    for (int i = 0; i < len; i++) {
      alphabet[enName.charAt(i) - 'A']++;
    }
    // 전부 다 짝수개 이거나, 하나만 홀수개 이거나
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] % 2 == 1) {
        check++;
      }
    }
    if (check > 1) {
      System.out.println("I'm Sorry Hansoo");
    } else {
      for (int i = 0; i < 26; i++) {
        while (alphabet[i] > 0) {
          if (alphabet[i] % 2 == 0) {
            ans[idx] = (char)('A' + i);
            ans[len - 1 - idx] = (char)('A' + i);

            alphabet[i] -= 2;
            idx++;
          } else {
            ans[len / 2] = (char)('A' + i);
            alphabet[i]--;
          }
          
        }
      }
      System.out.println(String.valueOf(ans));
    }
  }
  
}
