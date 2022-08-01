package p1244;

import java.util.*;
import java.io.*;

public class Main {
  static int numOfSwitches, numOfStudents;
  static boolean[] switches;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    numOfSwitches = Integer.parseInt(br.readLine());

    switches = new boolean[numOfSwitches + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= numOfSwitches; i++) {
      String cur = st.nextToken();
      if (cur.charAt(0) == '1') {
        switches[i] = true;
      }
    }

    numOfStudents = Integer.parseInt(br.readLine());

    for (int i = 0; i < numOfStudents; i++) {
      st = new StringTokenizer(br.readLine());

      int gender = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if (gender == 1) {
        for (int j = num; j <= numOfSwitches; j += num) {
          switches[j] ^= true;
        }
      } else {
        switches[num] ^= true;
        for (int j  = 1; num + j <= numOfSwitches && num - j > 0; j++) {
          if (switches[num + j] == switches[num - j]) {
            switches[num + j] ^= true;
            switches[num - j] ^= true;
          } else {
            break;
          }
        }
      }
    }

    for (int i = 1; i <= numOfSwitches; i++) {
      if (switches[i]) {
        sb.append(1);
      } else {
        sb.append(0);
      }
      sb.append(" ");
      if (i % 20 == 0) {
        sb.append("\n");
      }
    }

    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
}
