package P11000;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static class Time {
    int S, T;
    public Time (int s, int t) {
      this.S = s;
      this.T = t;
    }
  }
  static List<Time> list;
  static PriorityQueue<Integer> pq;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    list = new ArrayList<>();
    pq = new PriorityQueue<>();

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    Collections.sort(list, new Comparator<Time>() {
      @Override
      public int compare (Time o1, Time o2) {
        if (o1.S == o2.S) {
          return o1.T - o2.T;
        }
        return o1.S - o2.S;
      }
    });

    pq.add(list.get(0).T);
    
    for (int i = 1; i < N; i++) {
      if (pq.peek() <= list.get(i).S) {
        pq.poll();
      }
      pq.add(list.get(i).T);
    }

    System.out.println(pq.size());
    br.close();
  }
  
}
