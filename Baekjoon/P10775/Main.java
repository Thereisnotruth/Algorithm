package P10775;

import java.util.*;

public class Main {
  static int G, P, ans;
  static int[] plane;
  static int[] gates;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    G = sc.nextInt();
    P = sc.nextInt();

    plane = new int[P + 1];
    gates = new int[G + 1];

    for (int i = 1; i <= G; i++) {
      gates[i] = i;
    }
    for (int i = 1; i <= P; i++) {
      plane[i] = sc.nextInt();
    }

    for (int i = 1; i <= P; i++) {
      int docking = find(plane[i]);

      if (docking != 0) {
        union(docking, docking - 1);
        ans++;
      } else {
        break;
      }
    }

    
    System.out.println(ans);
  }
  
  static int find (int x) {
    if (x == gates[x]) {
      return gates[x];
    } else {
      return gates[x] = find(gates[x]);
    }
  }
  
  static void union (int u, int v) {
    u = find(u);
    v = find(v);

    gates[u] = v;
  }
}
