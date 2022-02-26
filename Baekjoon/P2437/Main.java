package P2437;

import java.util.*;

public class Main {
  static int N, sum;
  static int[] weights;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    
    weights = new int[N];
    for (int i = 0; i < N; i++) {
      weights[i] = sc.nextInt();
    }

    Arrays.sort(weights);


    for (int i = 0; i < N; i++) {
      if (weights[i] > sum + 1) {
        break;
      }
      sum += weights[i];
    }
    System.out.println(sum + 1);
  }
  
}
