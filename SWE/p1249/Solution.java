package p1249;

import java.util.*;
import java.io.*;
 
public class Solution {
    static int[][] board, dp;
    static int T, N;
    static Queue<Point> queue;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static class Point {
        int y, x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
         
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
             
            board = new int[N][N];
            dp = new int[N][N];
            queue = new LinkedList<>();
             
            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = row.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = board[0][0];
            queue.add(new Point(0, 0));
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                     
                    if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                        if (dp[ny][nx] > dp[cur.y][cur.x] + board[ny][nx]) {
                            dp[ny][nx] = dp[cur.y][cur.x] + board[ny][nx];
                            queue.add(new Point(ny, nx));
                        }
                    }
                }
            }
             
            sb.append("#");
            sb.append(t);
            sb.append(" ");
            sb.append(dp[N - 1][N - 1]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
 
}