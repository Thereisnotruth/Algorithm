package P1541;

import java.util.*;
import java.io.*;

public class Main {
  static int answer;
  static String equation;
  static boolean p;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    equation = br.readLine();
    st = new StringTokenizer(equation, "+-");

    answer = Integer.parseInt(st.nextToken());
    p = true;

    for (int i = 0; i < equation.length(); i++) {
      if (p && equation.charAt(i) == '+') {
        answer += Integer.parseInt(st.nextToken());
      } else if (p && equation.charAt(i) == '-') {
        p = !p;
        answer -= Integer.parseInt(st.nextToken());
      } else if (!p && equation.charAt(i) == '+') {
        answer -= Integer.parseInt(st.nextToken());
      } else if (!p && equation.charAt(i) == '-') {
        answer -= Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(answer);
  }
}
