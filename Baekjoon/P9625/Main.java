package P9625;

import java.util.*;

public class Main {
  static int K;
  static int[] dpA, dpB;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    K = sc.nextInt();
    
    dpA = new int[46];
    dpB = new int[46];

    dpA[0] = 1;

    for (int i = 1; i <= 45; i++) {
      dpB[i] = dpA[i - 1] + dpB[i - 1];
      dpA[i] = dpB[i - 1];
    }

    System.out.println(dpA[K] + " " + dpB[K]);
  }
}
