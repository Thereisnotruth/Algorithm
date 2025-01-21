package P1991;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        graph = new int[26][2];

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            graph[root - 'A'][0] = left != '.' ? left - 'A' : -1;
            graph[root - 'A'][1] = right != '.' ? right - 'A' : -1;
        }
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void preOrder(int root) {
        if (root == -1)
            return;
        sb.append((char) (root + 'A'));
        preOrder(graph[root][0]);
        preOrder(graph[root][1]);
    }

    static void inOrder(int root) {
        if (root == -1)
            return;
        inOrder(graph[root][0]);
        sb.append((char) (root + 'A'));
        inOrder(graph[root][1]);
    }

    static void postOrder(int root) {
        if (root == -1)
            return;
        postOrder(graph[root][0]);
        postOrder(graph[root][1]);
        sb.append((char) (root + 'A'));
    }
}
