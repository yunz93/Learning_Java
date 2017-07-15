package LintCode;

/**
 * LintCode 41
 * 最大子数组
 * Created by Administrator on 2017/7/14 0014.
 */
public class Solution_41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        // write your code
        int curSum = 0;
        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if (curSum > maxSum) {
                maxSum = curSum;
            }
            //如果当前得到的和是个负数，那么这个和在接下来的累加中应该抛弃并重新清零
            if (curSum < 0) {
                curSum = 0;
            }
        }

        // 如果循环结束maxSum == 0
        // 说明数组中元素均为负,求最大值即可
        if(maxSum == 0){
            maxSum = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > maxSum){
                    maxSum = nums[i];
                }
            }
        }

        return maxSum;
    }
}
