package p17406;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, r, c, s, ans;
	static int[][] A, tmp, Ks;
	static boolean[] isSelected;
	static ArrayList<int[]> order;
	public static void main(String[] args) throws Exception { 
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];
		Ks = new int[K][3];
		isSelected = new boolean[K];
		tmp = new int[N + 1][M + 1];
		order = new ArrayList<>();
		ans = 987654321;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				Ks[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0, order);
		
		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	static void perm(int cnt, List<int[]> o) {
		if (cnt == K) {
			for (int i = 1; i <= N; i++) {
				tmp[i] = A[i].clone();
			}
			
			for (int i = 0; i < K; i++) {
				rotate(o.get(i)[0], o.get(i)[1], o.get(i)[2]);
			}
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += tmp[i][j];
				}
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		
		
		for (int i = 0; i < K; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			o.add(Ks[i]);
			perm(cnt + 1, o);
			isSelected[i] = false;
			o.remove(o.size() - 1);
		}
	}
	
	static void rotate(int r, int c, int s) {
		for (int i = 0; i < s; i++) {
			int startY = r - s + i;
			int startX = c - s + i;
			int endY = r + s - i;
			int endX = c + s - i;
			int startNum = tmp[startY][startX];
			// 왼쪽
			for (int j = startY; j < endY; j++) {
				tmp[j][startX] = tmp[j + 1][startX];
			}
			// 아래
			for (int j = startX; j < endX; j++) {
				tmp[endY][j] = tmp[endY][j + 1];
			}
			// 오른쪽
			for (int j = endY; j > startY; j--) {
				tmp[j][endX] = tmp[j - 1][endX];
			}
			// 위
			for (int j = endX; j > startX; j--) {
				tmp[startY][j] = tmp[startY][j - 1];
			}
			tmp[startY][startX + 1] = startNum;
		}
	}
}
