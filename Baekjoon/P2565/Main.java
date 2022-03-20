package P2565;

import java.util.*;

public class Main {
  static int n, ans;
  static List<Link> lines;
  static int[] dp, arr;
  static class Link {
    int a, b;
    public Link (int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    lines = new ArrayList<Link>();
    dp = new int[n];
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      lines.add(new Link(a, b));
    }

    Collections.sort(lines, new Comparator<Link>() {
      @Override
      public int compare(Link o1, Link o2) {
        return o1.a - o2.a;
      }
    });

    for (int i = 0; i < n; i++) {
      arr[i] = lines.get(i).b;
    }

    for (int i = 0; i < n; i++) {
      dp[i] = 1;

      for (int j = i - 1; j >= 0; j--) {
        if (lines.get(i).b > lines.get(j).b) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      ans = Math.max(ans, dp[i]);
    }

    System.out.println(n - ans);
  }
  
}
