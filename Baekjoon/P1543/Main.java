package P1543;

import java.util.*;

public class Main {
  static String str, word;
  static boolean[] search;
  static int ans;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    
    str = sc.nextLine();
    word = sc.nextLine();

    search = new boolean[str.length()];

    for (int i = 0; i < str.length() - word.length() + 1; i++) {
      if (str.substring(i, i + word.length()).equals(word) && !search[i]) {
        for (int j = i; j < i + word.length(); j++) {
          search[j] = true;
        }
        ans++;
      }
    }
    System.out.println(ans);
  }
  
}
