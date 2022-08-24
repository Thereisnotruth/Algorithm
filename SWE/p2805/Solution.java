package p2805;

import java.util.*;
import java.io.*;

public class Solution {
	static int T, N, ans;
	static int[][] farm;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input/p2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			farm = new int[N][N];
			ans = 0;

			int mid = N / 2;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
					if (Math.abs(mid - i) + Math.abs(mid - j) <= mid) {
						ans += farm[i][j];
					}
				}
			}

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
