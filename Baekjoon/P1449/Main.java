package P1449;

import java.util.*;

public class Main {
  static int N, L, ans;
  static int[] arr;
  static boolean[] check;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    L = sc.nextInt();

    arr = new int[N];
    check = new boolean[1001];
    for (int i = 0; i <= 1000; i++) {
      check[i] = true;
    }

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
      check[arr[i]] = false;
    }

    for (int i = 0; i <= 1000; i++) {
      if (check[i] == false) {
        for (int j = 0; j < L; j++) {
          if (i + j <= 1000) {
            check[i + j] = true;
          }
        }
        ans++;
      }
    }

    System.out.println(ans);
  }
  
}
