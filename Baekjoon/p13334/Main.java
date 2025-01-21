package p13334;

import java.util.*;
import java.io.*;

public class Main {
    static int n, d, ans;
    static PriorityQueue<Integer> pq;
    static List<int[]> commuteList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        pq = new PriorityQueue<>();

        commuteList = new ArrayList<>();
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int home = Integer.parseInt(st.nextToken());
            int office = Integer.parseInt(st.nextToken());

            if (home > office) {
                commuteList.add(new int[] { office, home });
            } else {
                commuteList.add(new int[] { home, office });
            }
        }
        d = Integer.parseInt(br.readLine());

        commuteList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < commuteList.size(); i++) {
            int[] currentCommute = commuteList.get(i);
            pq.add(currentCommute[0]);

            while (!pq.isEmpty() && pq.peek() < currentCommute[1] - d)
                pq.remove();

            ans = Math.max(ans, pq.size());
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        br.close();
        bw.close();
    }
}
