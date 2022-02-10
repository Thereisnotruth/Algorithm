package P10162;

import java.util.*;

public class Main {
  static int[] time = { 300, 60, 10 };
  static int[] answer = new int[3];
  static int T;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    T = sc.nextInt();

    if (T % 10 != 0) {
      System.out.println(-1);
    } else {
      for (int i = 0; i < 3; i++) {
        while (T >= time[i]) {
          T -= time[i];
          answer[i]++;
        }
      }
      for (int i = 0; i < 3; i++) {
        System.out.print(answer[i] + " ");
      }
    }
  }
  
}
