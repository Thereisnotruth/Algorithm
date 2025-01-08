package p3190;

import java.util.*;
import java.io.*;

public class Main {
    static int N, K, L, ans;
    static int[][] board;
    static Queue<Move> moveList;
    static boolean[][] visited;
    // 0 - 상, 1 - 우, 2 - 하, 3 - 좌
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static Deque<int[]> snake;

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

        snake = new ArrayDeque<>();
        moveList = new LinkedList<>();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 0 - 빈 공간
        // 1 - 뱀이 있는 공간
        // 2 - 사과가 있는 공간
        board = new int[N][N];

        // 사과 배치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y - 1][x - 1] = 2;
        }

        L = Integer.parseInt(br.readLine());

        // 방향 전환 정보 저장
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int seconds = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            moveList.add(new Move(seconds, direction));
        }

        // 1. 뱀이 벽에 닿으면 게임 종료
        // 2. 뱀이 자기 몸에 닿으면 게임 종료
        // 3. 경로에 사과가 있으면 뱀의 길이 증가

        snake.add(new int[] { 0, 0 });
        board[0][0] = 1;
        move(1);

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    static void move(int direction) {
        ans++;
        int[] head = snake.getFirst();
        int ny = head[0] + dy[direction];
        int nx = head[1] + dx[direction];

        // 벽에 닿으면 게임 종료
        if (ny >= N || nx >= N || ny < 0 || nx < 0) {
            return;
        }

        // 뱀의 몸에 닿으면 게임 종료
        if (board[ny][nx] == 1) {
            return;
        }

        if (board[ny][nx] == 2) {
            // 사과가 있는 공간일 경우 - 뱀 길이 증가
            snake.addFirst(new int[] { ny, nx });
            board[ny][nx] = 1;
        } else {
            // 빈 공간일 경우 - 꼬리 이동
            snake.addFirst(new int[] { ny, nx });
            board[ny][nx] = 1;
            int[] tail = snake.pollLast();
            board[tail[0]][tail[1]] = 0;
        }

        int newDirection = direction;
        // 방향 전환 횟수가 남았을 때
        if (!moveList.isEmpty()) {
            Move move = moveList.peek();
            // 다음 방향 전환 정보와 현재 시간 비교
            if (ans == move.seconds) {
                moveList.poll();
                // 방향 전환 시간이면 어느 방향으로 전환할 지 체크
                if (move.direction == 'L') {
                    // L이면 왼쪽으로 90도 회전
                    newDirection--;
                    if (newDirection < 0)
                        newDirection = 3;
                } else {
                    // D이면 오른쪽으로 90도 회전
                    newDirection++;
                    if (newDirection >= 4) {
                        newDirection = 0;
                    }
                }
            }
        }
        move(newDirection);
    }
}
