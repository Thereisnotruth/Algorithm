package P4179;

import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static Queue<Point> queue;
    static Pair[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Point> exitList;
    static class Point {
        int y, x;
        char type;
        public Point (int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
    static class Pair {
        int J, F;
        public Pair (int j, int f) {
            this.J = j;
            this.F = f;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        board = new char[R][C];
        visited = new Pair[R][C];
        queue = new LinkedList<>();
        exitList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if (ch == '#') {
                    visited[i][j] = new Pair(0, 0);
                } else {
                    if (i == 0 || i == (R - 1) || j == 0 || j == (C - 1)) {
                        exitList.add(new Point(i, j, 'E'));
                    }
                    if (ch == 'J') {
                        queue.offer(new Point(i, j, 'J'));
                        visited[i][j] = new Pair(0, -1);
                    } else if (ch == 'F') {
                        queue.offer(new Point(i, j, 'F'));
                        visited[i][j] = new Pair(-1, 0);
                    } else if (ch == '.') {
                        visited[i][j] = new Pair(-1, -1);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (cur.type == 'J') {
                    if (visited[ny][nx].J >= 0 || board[ny][nx] == '#') {
                        continue;
                    }
                    visited[ny][nx].J = visited[cur.y][cur.x].J + 1;
                    queue.offer(new Point(ny, nx, 'J'));
                } else if (cur.type == 'F') {
                    if (visited[ny][nx].F >= 0 || board[ny][nx] == '#') {
                        continue;
                    }
                    visited[ny][nx].F = visited[cur.y][cur.x].F + 1;
                    queue.offer(new Point(ny, nx, 'F'));
                }
            }
        }
        boolean possible = false;
        int minJ = Integer.MAX_VALUE;
        for (int i = 0; i < exitList.size(); i++) {
            Pair cur = visited[exitList.get(i).y][exitList.get(i).x];
            if (cur.F >= 0 && cur.J >= cur.F) {
                continue;
            } else {
                if (cur.J >= 0 && cur.J < minJ) {
                    possible = true;
                    minJ = cur.J;
                }
            }
        }

        if (possible) {
            System.out.println(minJ + 1);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}