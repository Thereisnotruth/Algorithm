package P1339;

import java.util.*;

public class Main {
  static int n, ans, value = 9;
  static int[] alphabet = new int[26];
  static char[] arr;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      arr = sc.next().toCharArray();
      int pos = (int) Math.pow(10, arr.length - 1);

      for (int j = 0; j < arr.length; j++) {
        alphabet[arr[j] - 'A'] += pos;
        pos /= 10;
      }
    }
    Arrays.sort(alphabet);

    for (int i = alphabet.length - 1; i >= 0; i--) {
      if (value == 0) {
        break;
      }
      ans += alphabet[i] * value--;
    }
    System.out.println(ans);
  }
  
}
