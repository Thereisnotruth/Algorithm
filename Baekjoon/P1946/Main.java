package P1946;

import java.util.*;
import java.io.*;

public class Main {
  static int T, N, answer;
  static class Person {
    int dScore, iScore;
    public Person (int d, int i) {
      this.dScore = d;
      this.iScore = i;
    }
  }
  static Person[] arr;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      N = Integer.parseInt(br.readLine());
      
      answer = 0;
      arr = new Person[N];
      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        int dS = Integer.parseInt(st.nextToken());
        int iS = Integer.parseInt(st.nextToken());

        arr[n] = new Person(dS, iS);
      }
      Arrays.sort(arr, new Comparator<Person>() {
        @Override
        public int compare (Person o1, Person o2) {
          return o1.dScore - o2.dScore;
        }
      });

      int max = arr[0].iScore;
      for (int i = 0; i < N; i++) {
        if (arr[i].iScore <= max) {
          answer++;
          max = arr[i].iScore;
        }
      }
      sb.append(answer + "\n");
    }
    System.out.println(sb.toString());
  } 
}
