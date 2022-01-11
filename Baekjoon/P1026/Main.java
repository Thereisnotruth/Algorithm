package P1026;

import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int[] a, b;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    b = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);
    Arrays.sort(b);

    System.out.println(S());

  }
  static int S () {
    int ret = 0;
    for (int i = 0; i < n; i++) {
      ret += a[n - i - 1] * b[i];
    }
    return ret;
  }
}
