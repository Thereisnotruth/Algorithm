package P9498;
// 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
import java.io.*;
import java.util.*;

public class Main {
    static int A;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = Integer.parseInt(br.readLine());

       if (A < 60) {
           bw.write("F");
       } else if (A < 70) {
           bw.write("D");
       } else if (A < 80) {
           bw.write("C");
       } else if (A < 90) {
           bw.write("B");
       } else {
           bw.write("A");
       }

        bw.flush();
        bw.close();
        br.close();
    }
}
