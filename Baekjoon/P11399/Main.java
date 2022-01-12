package P11399;

import java.util.*;

public class Main {
  static int n, answer;
  static int[] arr;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    answer = arr[0];

    for (int i = 1; i < n; i++) {
      arr[i] = arr[i - 1] + arr[i];
      answer += arr[i];
    }
    System.out.println(answer);
  }
  
}
