package P11047;

import java.util.*;

public class Main {
  static int n, k, answer, idx;
  static int[] money;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    money = new int[n];

    for (int i = 0; i < n; i++) {
      money[i] = sc.nextInt();
    }

    idx = n - 1;
    while (k != 0 && idx >= 0) {
      if (money[idx] > k) {
        idx--;
      } else {
        k -= money[idx];
        answer++;
      }
    }
    System.out.println(answer);
  }
  
}
