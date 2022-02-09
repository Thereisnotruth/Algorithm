package P10610;

import java.util.*;

public class Main {
  static String input, answer = "";
  static String[] arr;
  static int check1;
  static boolean check2;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    input = sc.next();
    
    arr = new String[input.length()];

    for (int i = 0; i < input.length(); i++) {
      arr[i] = String.valueOf(input.charAt(i));
      if (arr[i].equals("0")) {
        check2 = true;
      }
    }
    Arrays.sort(arr, Collections.reverseOrder());

    for (int i = 0; i < input.length(); i++) {
      if (arr[i].equals("0")) {
        break;
      }
      check1 += Integer.parseInt(arr[i]);
    }

    if (check1 % 3 == 0 && check2) {
      for (int i = 0; i < input.length(); i++) {
        answer += arr[i];
      }
      System.out.println(answer);
    } else {
      System.out.println(-1);
    }
  }
  
}
