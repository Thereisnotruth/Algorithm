package P1012;

import  java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K, Y, X, cnt;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Point {
        int y, x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            board = new int[N][M];
            visited = new boolean[N][M];
            queue = new LinkedList<>();
            cnt = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());

                board[Y][X] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (board[y][x] == 1 && !visited[y][x]) {
                        cnt++;
                        visited[y][x] = true;
                        queue.offer(new Point(y, x));

                        while (!queue.isEmpty()) {
                            Point cur = queue.poll();

                            for (int t = 0; t < 4; t++) {
                                int ny = cur.y + dy[t];
                                int nx = cur.x + dx[t];

                                if (ny < 0  || nx < 0 || ny >= N || nx >= M) {
                                    continue;
                                }
                                if (visited[ny][nx] || board[ny][nx] == 0) {
                                    continue;
                                }
                                visited[ny][nx] = true;
                                queue.offer(new Point(ny, nx));
                            }
                        }
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
}
