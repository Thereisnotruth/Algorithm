package p3190;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, K, L, ans, direction;
    static int[][] board;
    static Deque<int[]> snake;
    static Queue<Move> movingList;
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    static class Move {
        int seconds;
        char direction;

        public Move(int seconds, char direction) {
            this.seconds = seconds;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 0: 빈 칸, 1: 뱀, 2: 사과
        board = new int[N][N];
        snake = new ArrayDeque<>();
        movingList = new LinkedList<>();

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y - 1][x - 1] = 2;
        }
        board[0][0] = 1;
        snake.add(new int[] { 0, 0 });

        L = Integer.parseInt(br.readLine());
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            int seconds = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            movingList.add(new Move(seconds, direction));
        }

        while (true) {
            // 시간 증가
            ans++;

            int[] head = snake.peekFirst();
            int ny = head[0] + dy[direction];
            int nx = head[1] + dx[direction];

            // 다음 칸 확인, 벽 또는 몸통 -> 게임 종료
            if (ny >= N || nx >= N || ny < 0 || nx < 0 || board[ny][nx] == 1) {
                break;
            }

            snake.addFirst(new int[] { ny, nx });

            if (board[ny][nx] != 2) {
                // 사과 칸 X -> 꼬리 이동
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }
            board[ny][nx] = 1;

            if (!movingList.isEmpty() && ans == movingList.peek().seconds) {
                Move move = movingList.remove();

                if (move.direction == 'L') {
                    direction--;
                    if (direction < 0)
                        direction = 3;
                } else {
                    direction++;
                    if (direction >= 4)
                        direction = 0;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
