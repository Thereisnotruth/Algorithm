package P2217;

import java.util.*;

public class Main {
  static int n, k, answer;
  static Integer[] rope;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    
    n = sc.nextInt();

    rope = new Integer[n];

    for (int i = 0; i < n; i++) {
      rope[i] = sc.nextInt();
    }

    Arrays.sort(rope, Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      k++;
      answer = Math.max(answer, rope[i] * k);
    }

    System.out.println(answer);
  }
  
}
