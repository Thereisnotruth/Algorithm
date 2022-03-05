package P1018;

import java.util.*;

public class Main {
  static int N, M, ans = 65;
  static char[][] board;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    board = new char[N][M];

    for (int i = 0; i < N; i++) {
      String row = sc.next();
      board[i] = row.toCharArray();
    }

    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        char check = 'W';
        int tmp = 0;
        for (int a = i; a < i + 8; a++) {
          for (int b = j; b < j + 8; b++) {
            if (check == board[a][b]) {
              tmp++;
            }
            if (check == 'W') {
              check = 'B';
            } else {
              check = 'W';
            }
          }
          if (check == 'W') {
            check = 'B';
          } else {
            check = 'W';
          }
        }
        ans = Math.min(ans, tmp);
        check = 'B';
        tmp = 0;
        for (int a = i; a < i + 8; a++) {
          for (int b = j; b < j + 8; b++) {
            if (check == board[a][b]) {
              tmp++;
            }
            if (check == 'W') {
              check = 'B';
            } else {
              check = 'W';
            }
          }
          if (check == 'W') {
            check = 'B';
          } else {
            check = 'W';
          }
        }
        ans = Math.min(ans, tmp);
      }
    }
    System.out.println(ans);
  }
  
}
