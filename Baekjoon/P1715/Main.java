package P1715;

import java.util.*;

public class Main {
  static int N;
  static long ans;
  static PriorityQueue<Long> decks;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    decks = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      decks.add(sc.nextLong());
    }

    while (decks.size() != 1) {
      long a = decks.remove();
      long b = decks.remove();
      ans += (a + b);
      decks.add(a + b);
    }
    System.out.println(ans);
  }
  
}
