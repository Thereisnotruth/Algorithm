package p1226;

import java.util.*;
import java.io.*;
 
public class Solution {
    static int T, sY, sX, dY, dX;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
         
        for (int t = 1; t <= 10; t++) {
            T = sc.nextInt();
             
            board = new int[16][16];
            visited = new boolean[16][16];
             
            for (int i = 0; i < 16; i++) {
                String row = sc.next();
                for (int j = 0; j < 16; j++) {
                    board[i][j] = row.charAt(j) - '0';
                    if (board[i][j] == 2) {
                        sY = i;
                        sX = j;
                    } else if (board[i][j] == 3) {
                        dY = i;
                        dX = j;
                    }
                }
            }
             
            visited[sY][sX] = true;
            dfs(sY, sX);
             
            System.out.printf("#%d ", T);
            if (visited[dY][dX]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    public static void dfs (int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < 16 && nx < 16 && !visited[ny][nx] && board[ny][nx] != 1) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}