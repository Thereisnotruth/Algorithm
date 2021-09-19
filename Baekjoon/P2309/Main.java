package P2309;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] arr;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new boolean[101];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            int tmp = sc.nextInt();
            arr[tmp] = true;
            sum += tmp;
        }
        int diff = sum - 100;
        for(int i = 1; i <= 100; i++) {
            if (diff - i > 0 && diff - i <= 100) {
                if (arr[i] && arr[diff - i]) {
                    arr[i] = false;
                    arr[diff - i] = false;
                    break;
                }
            }
        }
        for(int i = 1; i <= 100; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}