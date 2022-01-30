package P7568;

import java.util.*;

public class Main {
  static class Man {
    int height, weight;
    public Man (int w, int h) {
      this.weight = w;
      this.height = h;
    }
  }
  static int n, h, w, cnt;
  static int[] order;
  static Man[] mans;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    mans = new Man[n];
    order = new int[n];

    for (int i = 0; i < n; i++) {
      h = sc.nextInt();
      w = sc.nextInt();
      mans[i] = new Man(w, h);
    }

    for (int i = 0; i < n; i++) {
      cnt = 1;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (mans[i].weight < mans[j].weight && mans[i].height < mans[j].height) {
          cnt++;
        }
      }
      order[i] = cnt;
    }

    for (int i = 0; i < n; i++) {
      System.out.print(order[i] + " ");
    }
  }
  
}
