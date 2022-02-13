package P4796;

import java.util.*;
import java.io.*;

public class Main {
  static int L, P, V, idx = 1;;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());

      L = Integer.parseInt(st.nextToken());
      P = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      if (L == 0 && P == 0 && V == 0) {
        break;
      }

      sb.append("Case " + idx++ + ": " + (L * (V / P) + Math.min(L, V % P)) + "\n");
    }
    System.out.println(sb.toString());
  }
}
