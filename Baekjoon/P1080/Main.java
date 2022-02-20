package P1080;

import java.util.*;

public class Main {
  static int N, M, ans;
  static char[][] A, B;
  static boolean check;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    A = new char[N][M];
    B = new char[N][M];

    for (int i = 0; i < N; i++) {
      String row = sc.next();
      A[i] = row.toCharArray();
    }
    for (int i = 0; i < N; i++) {
      String row = sc.next();
      B[i] = row.toCharArray();
    }


    for (int i = 0; i < N - 2; i++) {
      for (int j = 0; j < M - 2; j++) {
        if (A[i][j] != B[i][j]) {
          ans++;
          reverse(i, j);
        }
      }
    }
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (A[i][j] != B[i][j]) {
          check = true;
          break;
        }
      }
      if (check) {
        break;
      }
    }
    if (check) {
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }
  }
  public static void reverse (int r, int c) {
    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        if (B[i][j] == '1') {
          B[i][j] = '0';
        } else {
          B[i][j] = '1';
        }
      }
    }
  }
  
}
