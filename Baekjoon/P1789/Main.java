package P1789;

import java.util.*;

public class Main {
  static long T, ans;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    T = sc.nextLong();

    while (T >= 0) {
      ans++;
      T -= ans;
    }
    System.out.println(ans - 1);
  }
  
}
