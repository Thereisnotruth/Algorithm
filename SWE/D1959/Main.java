package D1959;

import java.io.*;
import java.util.*;

public class Main {
  static int T, N, M, max, sum;
  static int[] A, B;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      max = 0;
      if (N > M) {
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
          A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
          B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N - M; i++) {
          sum = 0;
          for (int j = 0; j < M; j++) {
            sum += A[i + j] * B[j];
          }
          max = Math.max(max, sum);
        }
      } else {
        A = new int[M];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
          A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
          B[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= M - N; i++) {
          sum = 0;
          for (int j = 0; j < N; j++) {
            sum += A[j] * B[i + j];
          }
          max = Math.max(max, sum);
        }
      }
      sb.append("#" + t + " " + max + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
}
