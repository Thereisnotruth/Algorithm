package P1759;

import java.util.*;
import java.io.*;

public class Main {
  static int l, c;
  static char[] list;
  static List<String> answer;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    list = new char[c];
    answer = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < c; i++) {
      list[i] = st.nextToken().charAt(0);
    }

    for (int i = 0; i < c; i++) {
      solve(String.valueOf(list[i]));
    }

    Collections.sort(answer);

    for (int i = 0; i < answer.size(); i++) {
      sb.append(answer.get(i) + "\n");
    }
    
    bw.write(sb.toString());
    bw.flush();
    br.close(); bw.close();
  }

  static void solve (String str) {
    int len = str.length();
    if (len == l) {
      int m = 0;
      int j = 0;
      for (int i = 0; i < l; i++) {
        if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'|| 
        str.charAt(i) == 'o' || str.charAt(i) == 'u') {
          m++;
        } else {
          j++;
        }
      }
      if (m >= 1 && j >= 2) {
        answer.add(str);
      }
      return;
    }
    for (int i = 0; i < c; i++) {
      if (str.charAt(len - 1) - list[i] < 0) {
        solve(str + String.valueOf(list[i]));
      }
    }
  }
  
}
