package P10808;

import java.util.*;

public class Main {
    static String str;
    static int[] arr;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    
}
