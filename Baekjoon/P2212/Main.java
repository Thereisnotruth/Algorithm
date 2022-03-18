package P2212;

import java.util.*;
import java.io.*;

public class Main {
  static int n, k, ans;
  static Integer[] sensors, distances;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    sensors = new Integer[n];
    distances = new Integer[n - 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      sensors[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(sensors);

    for (int i = 0; i < n - 1; i++) {
      distances[i] = sensors[i + 1] - sensors[i];
    }

    Arrays.sort(distances, Collections.reverseOrder());

    if (n <= k) {
      System.out.println(0);
    } else {
      for (int i = k - 1; i < n - 1; i++) {
        ans += distances[i];
      }
      System.out.println(ans);
    }
  }
}
