package P2263;

import java.util.*;

public class Main {
    static int N;
    static int[] inOrder, postOrder, preOrder;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        inOrder = new int[N];
        postOrder = new int[N];
        preOrder = new int[N];

        for (int i = 0; i < N; i++) {
            inOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            postOrder[i] = sc.nextInt();
        }

        DFS(0, N - 1, 0, N - 1);
    }
    
    static void DFS (int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }
        int rootNode = postOrder[postEnd];
        System.out.print(rootNode + " ");
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootNode) {
                rootIndex = i;
                break;
            }
        }
        DFS(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        DFS(rootIndex + 1, inEnd, rootIndex + postStart - inStart, postEnd - 1);
    }
}
