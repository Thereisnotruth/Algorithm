package P2576;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0, min = 100;

        for (int i = 0; i < 7; i++) {
            int input = sc.nextInt();

            if (input % 2 == 1) {
                sum += input;
                if (min > input) {
                    min = input;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
