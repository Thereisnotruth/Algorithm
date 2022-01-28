package P4673;

import java.util.*;

public class Main {
  static boolean[] d;
  static StringBuilder sb;
  public static void main (String[] args) {
    sb = new StringBuilder();
    d = new boolean[10001];
    for (int i = 1; i <= 10000; i++) {
      D(i);
    }
    for (int i = 1; i <= 10000; i++) {
      if (!d[i]) {
        sb.append(i + "\n");
      }
    }
    System.out.println(sb.toString());
  }
  static void D (int n) {
    String tmp = String.valueOf(n);
    int next = n;
    for (int i = 0; i < tmp.length(); i++) {
      next += Integer.parseInt(tmp.substring(i, i + 1));
    }
    if (next <= 10000) {
      d[next] = true;
      D(next);
    }
  }
}
