package p2636;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, prev, t, num;
  static int[][] cheese;
  static Queue<int[]> queue;
  static int[] dy = { -1, 1, 0, 0 };
  static int[] dx = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    cheese = new int[N][M];
    queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < M; j++) {
        cheese[i][j] = Integer.parseInt(st.nextToken());
        if (cheese[i][j] == 1) {
          num++;
        }
      }
    }

    cheese[0][0] = 2;
    queue.add(new int[] { 0, 0 });
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if (ny >= 0 && nx >= 0 && ny < N && nx < M && cheese[ny][nx] == 0) {
          cheese[ny][nx] = 2;
          queue.add(new int[] { ny, nx });
        }
      }
    }
    /*
     * 2로 채움
     * 2근처 1을 0으로 바꾸기
     * 2근처 0을 2로 바꾸기
     * 1이 사라질 때 까지 2를 반복
     * 1이 사라지면 직전 값 출력
     */
    while (true) {
      t++;
      prev = num;
      for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
          if (cheese[i][j] == 1
              && (cheese[i - 1][j] == 2 || cheese[i + 1][j] == 2 || cheese[i][j - 1] == 2 || cheese[i][j + 1] == 2)) {
            cheese[i][j] = 0;
            num--;
          }
        }
      }
      if (num == 0) {
        break;
      }
      for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
          if (cheese[i][j] == 0
              && (cheese[i - 1][j] == 2 || cheese[i + 1][j] == 2 || cheese[i][j - 1] == 2 || cheese[i][j + 1] == 2)) {
            cheese[i][j] = 2;
            queue.add(new int[] { i, j });
            while (!queue.isEmpty()) {
              int[] cur = queue.poll();

              for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];

                if (ny > 0 && nx > 0 && ny < N - 1 && nx < M - 1 && cheese[ny][nx] == 0) {
                  cheese[ny][nx] = 2;
                  queue.add(new int[] { ny, nx });
                }
              }
            }
          }
        }
      }
    }
    bw.write(t + "\n" + prev + "\n");
    bw.flush();
    br.close();
    bw.close();
  }

}
