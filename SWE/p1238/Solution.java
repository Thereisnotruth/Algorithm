package p1238;

import java.util.*;
import java.io.*;
 
public class Solution {
    static int T = 10, N, startNum, lastLv;
    static ArrayList[] graph;
    static ArrayList[] levels;
    static Queue<Level> queue;
    static boolean[] visited;
    static class Level {
        int node, level;
        public Level (int n, int l) {
            this.node = n;
            this.level = l;
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for (int t = 1; t <= 10; t++) {
            lastLv = 0;
            queue = new LinkedList<>();
            visited = new boolean[101];
            graph = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            levels = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                levels[i] = new ArrayList<Integer>();
            }
 
            st = new StringTokenizer(br.readLine());    
             
            N = Integer.parseInt(st.nextToken());
            startNum = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < N; i += 2) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                 
                graph[from].add(to);
            }
             
            visited[startNum] = true;
            queue.add(new Level(startNum, 1));
 
            while(!queue.isEmpty()) {
                Level cur = queue.poll();
                if (lastLv < cur.level) {
                    lastLv = cur.level;
                }
                levels[cur.level].add(cur.node);
                for (int i = 0; i < graph[cur.node].size(); i++) {
                    if (!visited[(int)graph[cur.node].get(i)]) {
                        visited[(int)graph[cur.node].get(i)] = true;
                        queue.add(new Level((int)graph[cur.node].get(i), cur.level + 1));
                    }
                }
            }
            Collections.sort(levels[lastLv]);
             
            sb.append("#");
            sb.append(t);
            sb.append(" ");
            sb.append(levels[lastLv].get(levels[lastLv].size() - 1));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
}