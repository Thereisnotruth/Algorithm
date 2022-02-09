package P5585;

import java.util.*;

public class Main {
  static int n, answer;
  static int[] en = { 500, 100, 50, 10, 5, 1 };
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = 1000 - sc.nextInt();

    for (int i = 0; i < 6; i++) {
      while (n >= en[i]) {
        n -= en[i];
        answer++;
      }
    }
    System.out.println(answer);
  }
  
}
