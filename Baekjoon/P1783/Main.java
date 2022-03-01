package P1783;

import java.util.*;

public class Main {
  static int N, M;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    if (N == 1) {
      System.out.println(1);
    } else if (N == 2) {
      System.out.println(Math.min(4, (M + 1) / 2));
    } else if (M <= 6) {
      System.out.println(Math.min(4, M));
    } else {
      System.out.println(M - 2);
    }
  }
  
}
