package P2720;

import java.util.*;

public class Main {
  static int T;
  static int[] coin = { 25, 10, 5, 1 };
  static int[] ans = new int[4];
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int cent = sc.nextInt();

      for (int j = 0; j < 4; j++) {
        ans[j] = cent / coin[j];
        cent %= coin[j];
        System.out.print(ans[j] + " ");
      }

      System.out.println();

    }
  }
  
}
