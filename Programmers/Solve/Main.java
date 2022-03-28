package Solve;

import 정렬.K번째수.*;

public class Main {
  public static void main (String[] args) {

    Solution s = new Solution();
    int[] arrays = { 1, 5, 2, 6, 3, 7, 4 };
    int[][] commands = {
      { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }
    };
    int[] ans = s.solution(arrays, commands);
    for (int i = 0; i < commands.length; i++) {
      System.out.println(ans[i]);
    }
  }
  
}
