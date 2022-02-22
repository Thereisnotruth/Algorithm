package P1744;

import java.util.*;

public class Main {
  static int N, ans;
  static PriorityQueue<Integer> positive;
  static PriorityQueue<Integer> negative;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    positive = new PriorityQueue<Integer>(Collections.reverseOrder());
    negative = new PriorityQueue<Integer>();

    for (int i = 0; i < N; i++) {
      int input = sc.nextInt();
      if (input > 0) {
        positive.add(input);
      } else {
        negative.add(input);
      }
    }

    while (positive.size() > 1) {
      int a = positive.poll();
      int b = positive.poll();

      if (b == 1) {
        ans += (a + b);
      } else {
        ans += (a * b);
      }
    }
    if (!positive.isEmpty()) {
      ans += positive.poll();
    }

    while (negative.size() > 1) {
      int a = negative.poll();
      int b = negative.poll();

      ans += (a * b);
    }
    if (!negative.isEmpty()) {
      ans += negative.poll();
    }

    System.out.println(ans);
  }
  
}
