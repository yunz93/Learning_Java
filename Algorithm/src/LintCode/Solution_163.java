package LintCode;

/**
 * lintcode 163 不同二叉查找树
 * 卡特兰数的递推公式为：f(n) = f(n-1)f(0) + f(n-2)f(1) + f(n-3)f(2) + ... + f(1)f(n-2) + f(n-1)f(0)
 * 很好理解,左子树节点个数从0~n-1,右子树从n-1~0
 * 左右子树的组合数相乘之和即为结果
 * Created by Administrator on 2017/8/7 0007.
 */
public class Solution_163 {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
