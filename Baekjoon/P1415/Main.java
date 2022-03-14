package P1415;

import java.util.*;

public class Main {
  static int N, zCnt = 1, length, maxi;
  static long ans;
  static int max = 500001, maxV = 100001; // 최대 값
  static boolean[] prime = new boolean[max]; // 소수판별용
  static int[] cnt = new int[maxV]; // 사탕개수
  static long[] dp = new long[max];
  static ArrayList<Integer> candies = new ArrayList<>(); // 사탕종류

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    // 소수 판별
    for (int i = 2; i < max; i++) {
      prime[i] = true;
    }
    for (int i = 2; i * i < max; i++) {
      if (prime[i]) {
        for (int j = i * i; j < max; j += i) {
          prime[j] = false;
        }
      }
    }

    N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      int v = sc.nextInt();
      if (v == 0) {
        zCnt++;
        continue;
      }
      if (cnt[v] == 0) {
        candies.add(v);
      }
      cnt[v]++;
    }

    length = candies.size();
    dp[0] = 1;
    for (int i = 0; i < length; i++) {
      for (int j = max - 1; j >= 0; j--) {
        for (int k = 1; k <= cnt[candies.get(i)]; k++) {
          if (j - candies.get(i) * k < 0) {
            break;
          }
          dp[j] += dp[j - candies.get(i) * k];
        }
      }
    }

    ans = 0;
    for (int i = 2; i < max; i++) {
      if (prime[i]) {
        ans += dp[i];
      }
    }
    System.out.println(ans * zCnt);
  }
  
}
