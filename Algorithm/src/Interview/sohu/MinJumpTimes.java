package Interview.sohu;

import java.util.*;

public class MinJumpTimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = in.nextInt();
        }

        int[] dp = new int[n];   // dp[i]表示调到第i个桩子需要的最少跳数
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (a[j] == 0)
                    continue;
                if (j + a[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        System.out.println(dp[n-1]==Integer.MAX_VALUE ? -1 : dp[n-1]);
    }
}
