package prob.N으로표현;

import java.util.*;

public class Solution {
  static int min = Integer.MAX_VALUE;

  public int solution(int N, int number) {
    dfs(0, N, number, 0);
    if (min == Integer.MAX_VALUE) {
      return -1;
    }
    return min;
  }

  public void dfs(int depth, int N, int number, int cur) {
    if (depth > 8) {
      return;
    }
    if (number == cur) {
      min = Math.min(depth, min);
      return;
    }

    int tmp = 0;

    for (int i = 0; i < 8; i++) {
      if (depth + i < 8) {
        tmp = tmp * 10 + N;
        dfs(depth + i + 1, N, number, cur + tmp);
        dfs(depth + i + 1, N, number, cur - tmp);
        dfs(depth + i + 1, N, number, cur * tmp);
        dfs(depth + i + 1, N, number, cur / tmp);
      }
    }
  }
}