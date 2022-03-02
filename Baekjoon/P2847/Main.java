package P2847;

import java.util.*;

public class Main {
  static int N, ans;
  static int[] arr;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = N - 2; i >= 0; i--) {
      while (arr[i] >= arr[i + 1]) {
        arr[i]--;
        ans++;
      }
    }

    System.out.println(ans);
  }
  
}
