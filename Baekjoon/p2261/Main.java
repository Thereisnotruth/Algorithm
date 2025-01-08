package p2261;

import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ans = solve(0, N);

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    static int calDist(int[] p1, int[] p2) {
        int distX = p1[0] - p2[0];
        int distY = p1[1] - p2[1];

        return distX * distX + distY * distY;
    }

    static int findMin(int start, int end) {
        int minDist = calDist(points[start], points[end - 1]);
        for (int i = start; i < end - 1; i++) {
            for (int j = i + 1; j < end; j++) {
                int dist = calDist(points[i], points[j]);
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist;
    }

    static int solve(int start, int end) {
        int gap = end - start - 1;

        if (gap < 3) {
            return findMin(start, end);
        }

        int mid = (start + end) / 2;
        int min = Math.min(solve(start, mid), solve(mid, end));

        List<int[]> checkList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (Math.pow(points[i][0] - points[mid][0], 2) < min) {
                checkList.add(points[i]);
            }
        }

        Collections.sort(checkList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int len = checkList.size();

        for (int i = 0; i < len; i++) {
            int[] cur = checkList.get(i);
            for (int j = i + 1; j < len; j++) {
                int[] tmp = checkList.get(j);
                if (Math.pow(cur[1] - tmp[1], 2) >= min)
                    break;
                min = Math.min(min, calDist(cur, tmp));
            }
        }
        return min;
    }
}
