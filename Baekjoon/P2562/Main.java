package P2562;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0, index = 0;
        for (int i = 1; i <= 9; i++) {
            int tmp = sc.nextInt();
            if(tmp > max) {
                index = i;
                max = tmp; 
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
