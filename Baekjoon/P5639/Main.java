package P5639;

import java.util.*;
import java.io.*;

public class Main {
    static int pointer;
    static String input;

    static class Node {
        Node left, right;
        int num;
        public Node (int num) {
            this.num = num;
        }
        public void insert (int num) {
            if (this.num > num) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node tree = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            tree.insert(Integer.parseInt(input));
        }
        postOrder(tree);
    }
    
    static void postOrder (Node tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.num);
    }
}
