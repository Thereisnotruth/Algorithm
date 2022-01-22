package P9655;

import java.util.*;

public class Main {
  static int n;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    if (n % 2 == 1) {
      System.out.println("SK");
    } else {
      System.out.println("CY");
    }
  }
  
}
