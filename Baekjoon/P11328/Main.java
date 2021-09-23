package P11328;

import java.util.*;

public class Main {
    static int[] arr1, arr2;
    static int N;
    static String str1, str2;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            arr1 = new int[26];
            arr2 = new int[26];
            str1 = sc.next();
            str2 = sc.next();

            for (int j = 0; j < str1.length(); j++) {
                arr1[str1.charAt(j) - 'a']++;
            }
            for (int j = 0; j < str2.length(); j++) {
                arr2[str2.charAt(j) - 'a']++;
            }
            boolean chk = true;
            for (int j = 0; j < 26; j++) {
                if (arr1[j] != arr2[j]) {
                    chk = false;
                    System.out.println("Impossible");
                    break;
                }
            }
            if (chk) {
                System.out.println("Possible");
            }
        }
    }
    
}
