package P16953;

import java.util.*;

public class Main {
  static int A, B, ans;
  static boolean check;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    A = sc.nextInt();
    B = sc.nextInt();
    
    while (B > 0) {
      if (A == B) {
        check = true;
        break;
      }
      if (B % 2 == 0) {
        B /= 2;
        ans++;
      } else {
        if (B % 10 == 1) {
          B /= 10;
          ans++;
        } else {
          break;
        }
      }
    }

    if (check) {
      System.out.println(ans + 1);
    } else {
      System.out.println(-1);
    }
  }
  
}
