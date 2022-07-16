package p1248;

import java.util.*;
import java.io.*;
 
public class Solution {
  static int T, V, E, N1, N2, numOfNodes, root, cur;
  static ArrayList<Integer> ancestors;
  static ArrayList[] graph;
  static Queue<Integer> queue;
  static int[] parent;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
 
    T = Integer.parseInt(br.readLine());
 
    for (int t = 1; t <= T; t++) {
        root = 0;
        numOfNodes = 0;
      ancestors = new ArrayList<>();
      queue = new LinkedList<>();
 
      st = new StringTokenizer(br.readLine());
       
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      N1 = Integer.parseInt(st.nextToken());
      N2 = Integer.parseInt(st.nextToken());
 
      graph = new ArrayList[V + 1];
      for (int i = 1; i <= V; i++) {
        graph[i] = new ArrayList<Integer>();
      }
      parent = new int[V + 1];
 
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < E; i++) {
        int p = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
 
        graph[p].add(c);
        parent[c] = p;
      }
 
      cur = N1;
      while (parent[cur] != 0) {
        int p = parent[cur];
        ancestors.add(p);
        cur = p;
      }
 
      cur = N2;
      while (true) {
        if (ancestors.indexOf(cur) >= 0) {
          root = ancestors.get(ancestors.indexOf(cur));
          break;
        }
        cur = parent[cur];
      }
 
      queue.add(root);
      while (!queue.isEmpty()) {
        cur = queue.poll();
        numOfNodes++;
 
        for (int i = 0; i < graph[cur].size(); i++) {
          queue.add((int)graph[cur].get(i));
        }
      }
      sb.append("#");
      sb.append(t);
      sb.append(" ");
      sb.append(root);
      sb.append(" ");
      sb.append(numOfNodes);
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    br.close();
    bw.close();
  }
}