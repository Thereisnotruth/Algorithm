package P1247;

import java.util.*;
import java.io.*;
 
public class Solution {
  static int T, N, x, y, answer;
  static int[][] points;
  static boolean[] visited;
 
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
 
    T = Integer.parseInt(br.readLine());
 
    for (int t = 1; t <= T; t++) {
      answer = 987654321;
 
      N = Integer.parseInt(br.readLine());
 
      points = new int[N + 2][2];
      visited = new boolean[N + 2];
   
      st = new StringTokenizer(br.readLine());
 
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      points[0][0] = x;
      points[0][1] = y;
 
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      points[N + 1][0] = x;
      points[N + 1][1] = y;
 
      for (int i = 1; i <= N; i++) {
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
 
        points[i][0] = x;
        points[i][1] = y; 
      }
       
        visited[0] = true;
        dfs(0, 0, 0);
 
      sb.append("#");
      sb.append(t);
      sb.append(" ");
      sb.append(answer);
      sb.append("\n");
 
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
 
  }
 
  public static void dfs (int num, int distance, int n) {
    if (num == N + 1) {
      if (n == N + 1) {
        answer = Math.min(answer, distance);
      }
      return;
    }
 
    for (int i = 1; i <= N + 1; i++) {
      if (visited[i]) {
        continue;
      }
      int tmpDist = Math.abs(points[num][0] - points[i][0]) + Math.abs(points[num][1] - points[i][1]);
      visited[i] = true;
      dfs(i, distance + tmpDist, n + 1);
      visited[i] = false;
    }
  }
}