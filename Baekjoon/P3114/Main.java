package P3114;

import java.util.*;
import java.io.*;

public class Main {
  static int R, C;
  static int[][] apple, banana, aSum, bSum, tSum, dp;
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    apple = new int[R + 1][C + 1];
    banana = new int[R + 1][C + 1];
    aSum = new int[R + 1][C + 1];
    bSum = new int[R + 1][C + 1];
    tSum = new int[R + 1][C + 1];
    dp = new int[R + 1][C + 1];

    for (int i = 1; i <= R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= C; j++) {
        String token = st.nextToken();
        if (token.charAt(0) == 'A') {
          apple[i][j] = Integer.parseInt(token.substring(1));
        } else {
          banana[i][j] = Integer.parseInt(token.substring(1));
        }
      }
    }

    for (int i = R; i >= 2; i--) {
      for (int j = 1; j <= C; j++) {
        aSum[i - 1][j] = aSum[i][j] + apple[i][j];
      }
    }

    for (int i = 1; i <= R - 1; i++) {
      for (int j = 2; j <= C; j++) {
        bSum[i + 1][j] = bSum[i][j] + banana[i][j];
      }
    }

    
    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        tSum[i][j] = aSum[i][j] + bSum[i][j];
      }
    }
    
    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        if (i == 1) {
          dp[i][j] = dp[i][j - 1] + tSum[i][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1] + tSum[i][j], Math.max(dp[i][j - 1] + tSum[i][j], dp[i - 1][j] - apple[i][j]));
        }
      }
    }
   
    bw.write(dp[R][C] + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
  
}
