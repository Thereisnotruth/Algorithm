package prob.정렬.K번째수;

import java.util.*;

public class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int n = commands.length;
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      int startIdx = commands[i][0] - 1;
      int endIdx = commands[i][1];
      int ansIdx = commands[i][2] - 1;
      int[] tmpArr = Arrays.copyOfRange(array, startIdx, endIdx);
      Arrays.sort(tmpArr);
      answer[i] = tmpArr[ansIdx];
    }
    return answer;
  }
}
