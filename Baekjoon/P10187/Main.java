package P10187;

import java.io.*;
import java.util.*;

public class Main {
	static int N, X;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int tmp;
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			
			if(tmp < X) {
				sb.append(tmp + " ");
			}
		}
		
		bw.write(sb.toString() + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

}
