package P15903;

import java.util.*;
import java.io.*;

public class Main {
  static long n, m, ans;
  static PriorityQueue<Long> deck;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    deck = new PriorityQueue<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      deck.add(Long.parseLong(st.nextToken()));
    }

    for (int i = 0; i < m; i++) {
      long a = deck.poll();
      long b = deck.poll();
      deck.add(a + b);
      deck.add(a + b);
    }

    while (!deck.isEmpty()) {
      ans += deck.poll();
    }

    System.out.println(ans);
  }
}
