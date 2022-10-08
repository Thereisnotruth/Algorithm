package Solve;

import java.util.*;
import dev.p1.*;

public class Main {
  public static void main(String[] args) {
    String[] registered_list = {
        "cow", "cow1", "cow2", "cow3", "cow4", "cow5", "cow6", "cow7", "cow8", "cow9",
    };
    String new_id = "cow";
    Solution s = new Solution();
    String answer = s.solution(registered_list, new_id);
    System.out.println(answer);
  }

}
