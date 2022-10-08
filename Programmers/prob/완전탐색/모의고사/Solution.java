package prob.완전탐색.모의고사;

import java.util.*;

class Solution {
    static int[] answers1 = { 1, 2, 3, 4, 5 };
    static int[] answers2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
    static int[] answers3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    static int[] scores = new int[3];

    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answers1[i % 5]) {
                scores[0]++;
            }
            if (answers[i] == answers2[i % 8]) {
                scores[1]++;
            }
            if (answers[i] == answers3[i % 10]) {
                scores[2]++;
            }
        }
        int maxAnswer = Math.max(scores[0], Math.max(scores[1], scores[2]));
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (maxAnswer == scores[i]) {
                tmp.add(i + 1);
            }
        }
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}