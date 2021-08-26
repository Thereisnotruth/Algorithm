package P2225;

import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new long[201][201];
		
		for(int i = 0; i <= N; i++) {
			dp[1][i] = 1;
		}
		for(int i = 0; i <= N; i++) {
			dp[2][i] = i + 1;
		}
		
		for(int i = 3; i <= K; i++) {
			for(int j = 0; j <= N; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k] ;
				}
				dp[i][j] %= 1000000000;
			}
		}
		
		bw.write(String.valueOf(dp[K][N]) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

}
