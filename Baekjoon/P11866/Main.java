package P11866;

import java.util.*;

public class Main {
  static int n, k, cnt;
  static Queue<Integer> q;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    q = new LinkedList<Integer>();

    n = sc.nextInt();
    k = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      q.add(i);
    }

    sb.append("<");
    while (!q.isEmpty()) {
      cnt++;
      if (cnt == k) {
        sb.append(q.remove() + ", ");
        cnt = 0;
      } else {
        q.add(q.remove());
      }
    }
    sb.deleteCharAt(sb.lastIndexOf(","));
    sb.deleteCharAt(sb.lastIndexOf(" "));
    sb.append(">");
    System.out.println(sb.toString());
  }
  
}
