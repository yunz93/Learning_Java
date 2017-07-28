package LintCode;

/**
 * LintCode 363
 * 接雨水
 * 要求时间复杂度O(n)，空间复杂度O(1)
 * 思路是设置前后两个指针同时往中间走，同时动态调节两边沿高度，
 * 当两指针范围内有低于较低边沿值，即可接水
 * Created by Administrator on 2017/7/26 0026.
 */
public class Solution_363 {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (null == heights || heights.length < 3) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;

        while (left <= right) {
            leftMax = Math.max(leftMax, heights[left]);
            rightMax = Math.max(rightMax, heights[right]);

            if (leftMax <= rightMax) {
                if (leftMax > heights[left]) {
                    area += leftMax - heights[left];
                }
                left++;
            } else {
                if (rightMax > heights[right]) {
                    area += rightMax - heights[right];
                }
                right--;
            }
        }
        return area;
    }
}
