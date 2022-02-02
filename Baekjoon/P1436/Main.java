package P1436;

import java.util.*;

public class Main {
  static int n, ans, cnt, tmp;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    while (cnt != n) {
      ans++;
      tmp = ans;

      while (tmp != 0) {
        if (tmp % 1000 == 666) {
          cnt++;
          break;
        } else {
          tmp /= 10;
        }
      }
    }
    System.out.println(ans);
  }
  
}
