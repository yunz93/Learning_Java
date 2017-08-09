package LintCode;

/**
 * LintCode 515 房屋染色
 * 比较亮的点在于用一个二维数组循环去记录两步操作的dp值
 * 基本思路是，每一步计算上一步不同列的最小值与本列的和，作为这一步本列的值
 * 最后找到最后一步的最小列即可
 * Created by Administrator on 2017/8/9 0009.
 */
public class Solution_515 {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;

        int[][] dp = new int[2][3];

        int old, now = 0;
        dp[now][0] = dp[now][1] = dp[now][2] = 0;

        int i, j, k;
        for (i = 1; i <= n; ++i) {
            old = now;
            now = 1 - now;
            for (j = 0; j < 3; ++j) {
                dp[now][j] = Integer.MAX_VALUE;
                for (k = 0; k < 3; ++k) {
                    if (k != j && dp[old][k] + costs[i-1][j] < dp[now][j]) {
                        dp[now][j] = dp[old][k] + costs[i-1][j];
                    }
                }
            }
        }


        return Math.min(dp[now][0], Math.min(dp[now][1], dp[now][2]));
    }
}
