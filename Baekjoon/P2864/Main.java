package P2864;

import java.util.*;

public class Main {
  static String A, B, tmpA = "", tmpB = "";
  static int min, max;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    A = sc.next();
    B = sc.next();

    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '6') {
        tmpA += "5";
      } else {
        tmpA += String.valueOf(A.charAt(i));
      }
    }
    for (int i = 0; i < B.length(); i++) {
      if (B.charAt(i) == '6') {
        tmpB += "5";
      } else {
        tmpB += String.valueOf(B.charAt(i));
      }
    }

    min = Integer.parseInt(tmpA) + Integer.parseInt(tmpB);

    tmpA = ""; tmpB = "";
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '5') {
        tmpA += "6";
      } else {
        tmpA += String.valueOf(A.charAt(i));
      }
    }
    for (int i = 0; i < B.length(); i++) {
      if (B.charAt(i) == '5') {
        tmpB += "6";
      } else {
        tmpB += String.valueOf(B.charAt(i));
      }
    }

    max = Integer.parseInt(tmpA) + Integer.parseInt(tmpB);

    System.out.println(min + " " + max);
  }
  
}
