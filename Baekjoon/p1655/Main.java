package p1655;

import java.io.*;
import java.util.*;

public class Main {
    static int N, X;
    static PriorityQueue<Integer> maxHeap, minHeap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());

        // 맨 처음 숫자는 최대 힙에 삽입

        X = Integer.parseInt(br.readLine());
        maxHeap.add(X);
        sb.append(X).append("\n");

        for (int i = 0; i < N - 1; i++) {
            X = Integer.parseInt(br.readLine());

            if (X < maxHeap.peek()) {
                // 최대 힙 top보다 작으면 최대 힙에 삽입
                maxHeap.add(X);
            } else {
                // 최대 힙 top보다 크거나 같으면 최소 힙에 삽입
                minHeap.add(X);
            }

            // 두 힙의 사이즈가 같거나 최대 힙 크기 = 최소 힙 크기 + 1이 되도록 리밸런싱
            while (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.remove());
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
