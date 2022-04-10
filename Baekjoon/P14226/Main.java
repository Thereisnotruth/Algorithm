package P14226;

import java.util.*;

public class Main {
  static int S;
  static boolean[][] visited;
  static class Timeline {
    int display, clipboard, time;
    public Timeline (int d, int c, int t) {
      this.display = d;
      this.clipboard = c;
      this.time = t;
    }
  }
  static Queue<Timeline> queue;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    S = sc.nextInt();

    visited = new boolean[1001][1001];
    queue = new LinkedList<>();

    visited[1][0] = true;
    queue.add(new Timeline(1, 0, 0));

    while (!queue.isEmpty()) {
      Timeline cur = queue.poll();
      int display = cur.display;
      int clipboard = cur.clipboard;
      int time = cur.time;

      if (display == S) {
        System.out.println(time);
        break;
      }

      if (display > 0 && display < 1000) {
        if (!visited[display][display]) {
          visited[display][display] = true;
          queue.add(new Timeline(display, display, time + 1));
        }
        if ((display + clipboard) <= 1000 && !visited[display + clipboard][clipboard]) {
          visited[display + clipboard][clipboard] = true;
          queue.add(new Timeline(display + clipboard, clipboard, time + 1));
        }
        if (!visited[display - 1][clipboard]) {
          visited[display - 1][clipboard] = true;
          queue.add(new Timeline(display - 1, clipboard, time + 1));
        }
      }
    }
  }
  
}
