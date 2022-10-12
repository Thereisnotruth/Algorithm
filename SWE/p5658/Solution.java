package p5658;

import java.util.*;
import java.io.*;

public class Solution {
	static int T, N, K, ans;
	static String input;
	static Queue<Character> queue;
	static List<String> list;
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input/swe/p5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			queue = new ArrayDeque<>();
			list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int len = N / 4;
			
			input = br.readLine();
			
			for (int i = 0; i < input.length(); i++) {
				queue.add(input.charAt(i));
			}
			
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < 4; j++) {
					String num = "";
					for (int k = 0; k < len; k++) {
						num += queue.peek();
						queue.add(queue.poll());
					}
					if (!list.contains(num)) {
						list.add(num);
					}
				}
				queue.add(queue.poll());
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			ans = Integer.decode("0x" + list.get(K - 1));
			
			sb.append("#").append(t).append(" ");
			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
