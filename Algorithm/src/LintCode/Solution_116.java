package LintCode;

/**
 * LintCode 116
 * 跳跃游戏
 * 判断你是否能到达数组的最后一个位置
 * 动态规划 or 贪心
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution_116 {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    // dp
    public boolean canJump(int[] A) {
        // wirte your code here
        if (null == A || A.length <= 0){
            return false;
        }

        // dp[i] 表示前 i 位能够跳跃到的最大长度
        int[] dp = new int[A.length];

        // init
        dp[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            if (dp[i-1] >= i){
                dp[i] = dp[i-1] > (A[i] + i) ? dp[i-1] : (A[i] + i);
            } else {
                dp[i] = 0;
            }
        }

        return dp[A.length - 1] >= A.length - 1;
    }
}
