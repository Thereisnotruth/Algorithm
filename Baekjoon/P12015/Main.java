package P12015;

import java.util.*;
import java.io.*;

public class Main {
  static int N, ans;
  static int[] A;
  static ArrayList<Integer> dp;

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    A = new int[N + 1];
    dp = new ArrayList<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      if (dp.size() == 0) {
        dp.add(A[i]);
      } else if (dp.get(0) > A[i]) {
        dp.set(0, A[i]);
      } else if (dp.get(dp.size() - 1) < A[i]) {
        dp.add(A[i]);
      } else {
        dp.set(upperBound(A[i] - 1), A[i]);
      }
    }
    System.out.println(dp.size());

  }
  public static int upperBound(int target) {
    int begin = 0;
    int end = dp.size();
    
    while(begin < end) {
    	int mid = (begin + end) / 2;
        
        if(dp.get(mid) <= target) {
        	begin = mid + 1;
        }
        else {
        	end = mid;
        }
    }
    return end;
  }
}
