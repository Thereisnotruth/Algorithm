package P5052;

import java.util.*;
import java.io.*;

public class Main {
  static int t, n;
  static String[] number;
  static boolean answer;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      number = new String[n];
      answer = true;

      for (int i = 0; i < n; i++) {
        number[i] = br.readLine();
      }

      Arrays.sort(number);

      for (int i = 0; i < n - 1; i++) {
        if (number[i + 1].startsWith(number[i])) {
          answer = false;
          break;
        }
      }
      if (answer) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
    br.close(); bw.close();
  }
  
}
