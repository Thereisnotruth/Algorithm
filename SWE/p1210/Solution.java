package p1210;

import java.util.*;
import java.io.*;

public class Solution {
	static int T, n, ans;
	static int[][] ladders;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input/p1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = 10;

		for (int t = 1; t <= T; t++) {
			ladders = new int[100][100];

			n = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 100; j++) {
					ladders[i][j] = Integer.parseInt(st.nextToken());
					if (ladders[i][j] == 2) {
						climb(i, j);
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

	static void climb(int y, int x) {
		if (y == 0) {
			ans = x;
			return;
		}

		ladders[y][x]++;
		if (x - 1 >= 0 && ladders[y][x - 1] == 1) {
			climb(y, x - 1);
		} else if (x + 1 < 100 && ladders[y][x + 1] == 1) {
			climb(y, x + 1);
		} else {
			climb(y - 1, x);
		}
	}

}