package P2753;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        if(N % 4 == 0 && N % 100 != 0 || N % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
