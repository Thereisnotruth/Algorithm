package P1931;

import java.util.*;

public class Main {
  static int n, prevEndTime, answer;
  static int[][] time;
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    time = new int[n][2];

    for (int i = 0; i < n; i++) {
      time[i][0] = sc.nextInt();
      time[i][1] = sc.nextInt();
    }

    Arrays.sort(time, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
          return o1[0] - o2[0];
        }
        return o1[1] - o2[1];
      }
    });

    for (int i = 0; i < n; i++) {
      if (prevEndTime <= time[i][0]) {
        prevEndTime = time[i][1];
        answer++;
      }
    }

    System.out.println(answer);
  }
  
}
