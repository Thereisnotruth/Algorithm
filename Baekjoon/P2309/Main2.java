package P2309;

import java.io.*;
import java.util.*;

public class Main2 {
    static int[] heights = new int[9];
    static int[] ans = new int[7];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            int[] arr = new int[7];
            arr[0] = heights[i];
            comb(1, i, arr, arr[0]);
        }
        Arrays.sort(ans);

        for (int i = 0; i < 7; i++) {
            sb.append(ans[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    static void comb(int idx, int start, int[] arr, int sum) {
        if (sum > 100 || ans[0] != 0)
            return;
        if (idx == 7) {
            if (sum == 100) {
                ans = Arrays.copyOf(arr, 7);
            }
            return;
        }

        int[] newArr = Arrays.copyOf(arr, 7);

        for (int i = start + 1; i < 9; i++) {
            newArr[idx] = heights[i];
            comb(idx + 1, i, newArr, sum + newArr[idx]);
        }
    }
}
