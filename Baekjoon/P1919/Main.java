package P1919;

import java.util.*;

public class Main {
    static String str1, str2;
    static int[] alpha1, alpha2;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        alpha1 = new int[26];
        alpha2 = new int[26];

        str1 = sc.nextLine();
        str2 = sc.nextLine();

        for (int i = 0; i < str1.length(); i++) {
            alpha1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            alpha2[str2.charAt(i) - 'a']++;
        }

        int answer = 0;
        
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(alpha1[i] - alpha2[i]);
        }
        System.out.println(answer);
    }
    
}
