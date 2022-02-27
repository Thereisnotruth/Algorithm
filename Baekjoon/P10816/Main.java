package P10816;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static int[] arr;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      sb.append((upperBound(tmp) - lowerBound(tmp)) + " ");
    }

    System.out.println(sb.toString());
  }

  static int upperBound (int n) {
    int start, mid, end;
    start = 0;
    end = N;

    while (end > start) {
      mid = (start + end) / 2;
      if (arr[mid] > n) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }
  static int lowerBound (int n) {
    int start, mid, end;
    start = 0;
    end = N;

    while (end > start) {
      mid = (start + end) / 2;
      if (arr[mid] >= n) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }
  
}
