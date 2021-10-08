package P2667;

import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Integer> answer;
    static int  count;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        visited = new boolean[N][N];
        answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    count = 0;
                    DFS(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        int length = answer.size();
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(answer.get(i));
        }
    }
    static void DFS(int y, int x) {
        visited[y][x] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                continue;
            }
            if (visited[ny][nx] || board[ny][nx] == 0) {
                continue;
            }
            DFS(ny, nx);
        }
    }
}