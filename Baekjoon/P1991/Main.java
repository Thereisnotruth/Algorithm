package P1991;

import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        graph = new int[26][2];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                graph[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            char c = sc.next().charAt(0);
            if (b != '.') {
                graph[a - 'A'][0] = b - 'A';
            } 
            if (c != '.') {
                graph[a - 'A'][1] = c - 'A';
            }
        }
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        System.out.println(sb);
    }
    static void preOrder (int n) {
        sb.append((char)(n + 'A'));
        if (graph[n][0] != -1) {
            preOrder(graph[n][0]);
        }
        if (graph[n][1] != -1) {
            preOrder(graph[n][1]);
        }
    }
    static void inOrder (int n) {
        if (graph[n][0] != -1) {
            inOrder(graph[n][0]);
        }
        sb.append((char)(n + 'A'));
        if (graph[n][1] != -1) {
            inOrder(graph[n][1]);
        }
    }
    static void postOrder (int n) {
        if (graph[n][0] != -1) {
            postOrder(graph[n][0]);
        }
        if (graph[n][1] != -1) {
            postOrder(graph[n][1]);
        }
        sb.append((char)(n + 'A'));
    }
    
}
