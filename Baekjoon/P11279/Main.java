package P11279;

import java.util.*;

public class Main {
  static PriorityQueue<Integer> maxHeap;
  static int N;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    N = sc.nextInt();

    maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      int operation = sc.nextInt();

      if (operation == 0) {
        if (maxHeap.isEmpty()) {
          sb.append(0 + "\n");
        } else {
          sb.append(maxHeap.poll() + "\n");
        }
      } else {
        maxHeap.add(operation);
      }
    }
    System.out.println(sb.toString());
  }
  
}
