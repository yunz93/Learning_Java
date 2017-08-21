package LintCode;

/**
 * lintcode 14 二分查找
 */

class Solution_14 {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        if (target < nums[left] || target > nums[right]) {
            return -1;
        }
        int mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (target == nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        return -1;
    }
}
