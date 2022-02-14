package P11051;

import java.util.*;

public class Main {
  static int N, K;
  static int[][] binoCoeff;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    K = sc.nextInt();

    binoCoeff = new int[N + 1][K + 1];

    for (int i = 1; i <= K; i++) {
      binoCoeff[1][i] = 1;
    }
    for (int i = 1; i <= N; i++) {
      binoCoeff[i][0] = 1;
    }
    for (int i = 2; i <= N; i++) {
      for (int j = 1; j <= K && j <= i; j++) {
        if (i == j) {
          binoCoeff[i][j] = 1;
        } else {
          binoCoeff[i][j] = (binoCoeff[i - 1][j - 1] + binoCoeff[i - 1][j]) % 10007;
        }
      }
    }

    System.out.println(binoCoeff[N][K] % 10007);
  }
  
}
