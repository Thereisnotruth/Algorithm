package P1000;

import java.io.*;
import java.util.*;

public class Main {
	static int A, B;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf(A + B));
		bw.flush();
		br.close();
		bw.close();
	}

}
