package rock_festival;

import java.io.*;
import java.util.*;

public class Solution {
  static int C, N, L;
  static int[] arr;
  static double[] avg;
  static double ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    C = Integer.parseInt(br.readLine());

    for (int c = 0; c < C; c++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      L = Integer.parseInt(st.nextToken());

      arr = new int[N];
      avg = new double[N];
      ans = 987654321;

      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        avg[i] = 987654321;
      }

      for (int i = 0; i < N; i++) {
        double sum = 0;
        int cnt = 0;
        for (int j = i; j < N; j++) {
          sum += arr[j];
          cnt++;
          if (cnt >= L) {
            avg[i] = Math.min(avg[i], sum / cnt);
          }
        }
        ans = Math.min(ans, avg[i]);
      }
      sb.append(ans).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
}
