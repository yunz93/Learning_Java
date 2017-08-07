package LintCode;

/**
 * LintCode 117  跳跃游戏II
 * 这题与上一题不同的点在于是计算最少跳跃次数，贪心法比较容易求解
 * 不要一碰到这种问题就往dp里钻，思路打开往往豁然开朗
 * 遍历数组，记录前i位能够到达的最大距离，如果
 * Created by Administrator on 2017/8/7 0007.
 */
public class Solution_117 {
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int times = 0;
        int max = 0;
        int canReach = 0;

        for (int i = 0; i < A.length; i++) {
            if (canReach < i) {
                times++;
                canReach = max;
            }

            max = Math.max(max, A[i] + i);
        }
        return times;
    }
}
