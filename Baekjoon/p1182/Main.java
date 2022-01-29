package p1182;

import java.util.*;
import java.io.*;

public class Main {
  static int n, s, answer;
  static int[] arr;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    arr = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    solve(0, 0);
    if (s == 0) {
      answer--;
    }
    System.out.println(answer);
    br.close();
  }
  static void solve (int num, int sum) {
    if (num == n) {
      if (sum == s) {
        answer++;
      }
      return;
    }
    solve(num + 1, sum);
    solve(num + 1, sum + arr[num]);
  }
  
}
