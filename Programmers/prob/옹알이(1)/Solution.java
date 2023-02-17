import java.io.*;
import java.util.*;

class Solution {
  public int solution(String[] babbling) {
    int answer = 0;
    for (int i = 0; i < babbling.length; i++) {
      boolean isPass = true;
      for (int j = 0; j < babbling[i].length(); j++) {
        if (babbling[i].charAt(j) == 'a') {
          if (j + 3 <= babbling[i].length() && babbling[i].substring(j, j + 3).equals("aya")) {
            j += 2;
          } else {
            isPass = false;
            break;
          }
        } else if (babbling[i].charAt(j) == 'y') {
          if (j + 2 <= babbling[i].length() && babbling[i].substring(j, j + 2).equals("ye")) {
            j += 1;
          } else {
            isPass = false;
            break;
          }
        } else if (babbling[i].charAt(j) == 'w') {
          if (j + 3 <= babbling[i].length() && babbling[i].substring(j, j + 3).equals("woo")) {
            j += 2;
          } else {
            isPass = false;
            break;
          }
        } else if (babbling[i].charAt(j) == 'm') {
          if (j + 2 <= babbling[i].length() && babbling[i].substring(j, j + 2).equals("ma")) {
            j += 1;
          } else {
            isPass = false;
            break;
          }
        } else {
          isPass = false;
          break;
        }
      }

      if (isPass) answer++;
    }
    return answer;
  }
}
