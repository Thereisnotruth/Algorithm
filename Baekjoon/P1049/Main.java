package P1049;

import java.util.*;

public class Main {
  static int n, m, ans;
  static int[] set, single;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    set = new int[m];
    single = new int[m];

    for (int i = 0; i < m; i++) {
      set[i] = sc.nextInt();
      single[i] = sc.nextInt();
    }

    Arrays.sort(set);
    Arrays.sort(single);

    while (n > 0) {
      if (n > 6) {
        if (set[0] < single[0] * 6) {
          n -= 6;
          ans += set[0];
        } else {
          n--;
          ans += single[0];
        }
      } else {
        if (set[0] < single[0] * n) {
          n -= 6;
          ans += set[0];
        } else {
          n--;
          ans += single[0];
        }
      }
    }
    System.out.println(ans);
  }
  
}
