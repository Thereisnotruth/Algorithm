package P14888;

import java.util.*;

public class Main {
  static int N, max = -1000000001, min = 1000000001;
  static int[] numOfOper, arr;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    arr = new int[N];
    numOfOper = new int[4];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < 4; i++) {
      numOfOper[i] = sc.nextInt();
    }

    backtracking(arr[0], 1);

    System.out.println(max);
    System.out.println(min);
  }
  static void backtracking (int result, int idx) {
    if (idx == N) {
      if (result > max) {
        max = result;
      }
      if (result < min) {
        min = result;
      }
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (numOfOper[i] > 0) {
        numOfOper[i]--;
        if (i == 0) {
          backtracking(result + arr[idx], idx + 1);
        } else if (i == 1) {
          backtracking(result - arr[idx], idx + 1);
        } else if (i == 2) {
          backtracking(result * arr[idx], idx + 1);
        } else if (i == 3) {
          backtracking(result / arr[idx], idx + 1);
        }
        numOfOper[i]++;
      }
    }
  }
}
