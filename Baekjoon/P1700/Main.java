package P1700;

import java.util.*;
import java.io.*;

public class Main {
  static int N, K, ans, plug;
  static int[] order;
  static boolean[] use;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    order = new int[K];
    use = new boolean[101];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < K; i++) {
      order[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < K; i++) {
      if (!use[order[i]]) {
        if (plug < N) {
          use[order[i]] = true;
          plug++;
        } else {
          ArrayList<Integer> list = new ArrayList<>();

          for (int j = i; j < K; j++) {
            if (use[order[j]] && !list.contains(order[j])) {
              list.add(order[j]);
            }
          }

          if (list.size() < N) {
            for (int j = 0; j < 101; j++) {
              if (use[j] && !list.contains(j)) {
                use[j] = false;
                break;
              }
            }
          } else {
            int remove = list.get(list.size() - 1);
            use[remove] = false;
          }
          use[order[i]] = true;
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
  
}
