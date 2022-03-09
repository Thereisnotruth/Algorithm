package P2812;

import java.util.*;

public class Main {
  static int N, K;
  static String num;
  static StringBuilder sb;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    K = sc.nextInt();
    num = sc.next();

    sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      while (K > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < num.charAt(i)) {
        sb.deleteCharAt(sb.length() - 1);
        K--;
      }
      sb.append(num.charAt(i));
    }
    for (int i = 0; i < K; i++) {
      sb.deleteCharAt(sb.length() - 1);
    }
    System.out.println(sb.toString());
  }  
}
