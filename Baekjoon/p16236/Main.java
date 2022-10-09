package p16236;

import java.io.*;
import java.util.*;

public class Main {
  static int N, ans, size = 2, cnt, eatLv = -1, eatY, eatX;
  static int[][] map;
  static int[][] dp;
  static Queue<int[]> queue;
  static int[] dy = { -1, 0, 0, 1 };
  static int[] dx = { 0, -1, 1, 0 };

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    dp = new int[N][N];
    queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 9) {
          dp[i][j] = 1;
          map[i][j] = 0;
          queue.add(new int[] { i, j });
        }
      }
    }
    // 0 - y, 1 - x, 2 - distance
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
        if (eatLv == -1) {
          eatLv = dp[cur[0]][cur[1]];
          eatY = cur[0];
          eatX = cur[1];
        } else {
          if (eatLv == dp[cur[0]][cur[1]]) {
            if (eatY > cur[0]) {
              eatY = cur[0];
              eatX = cur[1];
            } else if (eatY == cur[0]) {
              if (eatX > cur[1]) {
                eatX = cur[1];
              }
            }

          }
        }
      }
      if (eatLv != -1 && (eatLv < dp[cur[0]][cur[1]] || queue.isEmpty())) {
        ans += eatLv - 1;
        if (++cnt == size) {
          size++;
          cnt = 0;
        }

        eatLv = -1;
        map[eatY][eatX] = 0;
        dp = new int[N][N];
        dp[eatY][eatX] = 1;
        queue.clear();
        queue.add(new int[] { eatY, eatX });

        continue;
      }

      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];
        if (ny >= 0 && nx >= 0 && ny < N && nx < N && dp[ny][nx] == 0 && map[ny][nx] <= size) {
          dp[ny][nx] = dp[cur[0]][cur[1]] + 1;
          queue.add(new int[] { ny, nx });
        }
      }
    }
    /*
     * 4 2 2 2 2 5 3 2 5 3 3 3 5 3 3 3 9
     * 
     */
    bw.write(ans + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
}
