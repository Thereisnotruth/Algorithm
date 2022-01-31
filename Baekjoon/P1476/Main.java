package P1476;

import java.util.*;

public class Main {
  static int e, s, m, answer;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    e = sc.nextInt();
    s = sc.nextInt();
    m = sc.nextInt();


    while (true) {
      e--; s--; m--; answer++;

      if (e == 0 && s == 0 && m == 0) {
        break;
      }
      if (e == 0) {
        e = 15;
      }
      if (s == 0) {
        s = 28;
      }
      if (m == 0) {
        m = 19;
      }
    }
    System.out.println(answer);
  }
  
}
