package dev.p1;

import java.util.*;

public class Solution {
  /*
   * S - 알파벳 소문자 길이 3~6
   * N - 숫자 길이 0~6
   * N의 길이가 1 이상이면 N의 첫자리는 0 불가
   * new_id가 registered_list 내에 없으면 new_id를 리턴
   * new_id가 registered_list 내에 있다면
   * new_id를 S와 N으로 분리
   * N을 10진수로 변환한 값 - n(N이 NULL이면 n은 0)
   * n+1을 문자열로 변환한 값 N1
   * new_id를 S + N1으로 변경하고 1로 돌아감
   */
  static boolean[] arr;

  public String solution(String[] registered_list, String new_id) {
    String answer = "";
    arr = new boolean[1000000];
    String S = "";
    String N = "";
    for (int i = 0; i < new_id.length(); i++) {
      char cur = new_id.charAt(i);
      if (cur >= '0' && cur <= '9') {
        N += cur;
      } else {
        S += cur;
      }
    }
    for (int i = 0; i < registered_list.length; i++) {
      if (registered_list[i].contains(S)) {
        String tmp = registered_list[i].replaceAll("[^0-9]", "");
        if (tmp.length() == 0) {
          arr[0] = true;
        } else {
          arr[Integer.parseInt(tmp)] = true;
        }
      }
    }

    int start = 0;
    if (N.length() != 0) {
      start = Integer.parseInt(N);
    }
    for (int i = start; i < 1000000; i++) {
      if (!arr[i]) {
        if (i == 0) {
          answer = S;
        } else {
          answer = S + i;
        }
        break;
      }
    }
    return answer;
  }
}