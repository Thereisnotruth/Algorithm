package P1654;

import java.util.*; 

public class Main {
  static int n, k, max, num, answer;
  static int[] arr;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    k = sc.nextInt();
    n = sc.nextInt();

    arr = new int[k];
    for (int i = 0; i < k; i++) {
      arr[i] = sc.nextInt();
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    for (int i = 0; i < k; i++) {
      num += (arr[i] / max);
    }
    if (num >= n) {
      System.out.println(max);
    } else {
      binarySearch(0, max);
      System.out.println(answer);
    }
  }
  static void binarySearch (int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = (right + left) / 2;
    num = 0;
    for (int i = 0; i < k; i++) {
      num += arr[i] / mid;
    }
    if (num >= n) {
      if (answer < mid) {
        answer = mid;
      }
      binarySearch(mid + 1, right);
    } else {
      binarySearch(left, mid);
    }

  }
  
}
