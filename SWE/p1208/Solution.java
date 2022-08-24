package p1208;

import java.io.*;
import java.util.*;

public class Solution {
	static int T, n, ans;
	static int[] heights;
	public static void main (String[] args) throws Exception {
		System.setIn(new FileInputStream("input/p1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = 10;
		
		for (int t = 1; t <= T; t++) {
			heights = new int[100];
			
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			
			Arrays.sort(heights);
			while (n-- > 0) {
				if (heights[0] == heights[99]) {
					break;
				}
				heights[99]--;
				heights[0]++;
				Arrays.sort(heights);
			}
			
			ans = heights[99] - heights[0];
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
