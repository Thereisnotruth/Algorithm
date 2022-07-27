package p9084;

import java.util.*;
import java.io.*;

public class Main {
	static int T, N, M;
	static int[] dp, arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			dp = new int[M + 1];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = arr[i]; j <= M; j++) {
					dp[j] += dp[j - arr[i]];
				}
				
			}
			
			sb.append(dp[M] + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
