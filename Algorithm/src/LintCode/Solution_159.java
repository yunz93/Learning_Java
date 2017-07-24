package LintCode;

/**
 * LintCode 159
 * 寻找旋转排序数组中的最小值
 * 要利用到旋转排序数组的特性，使用前后两个指针寻找突变发生的节点
 * Created by Administrator on 2017/7/20 0020.
 */
public class Solution_159 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (null == nums) {
            return 0;
        }

        return findMinCore(nums, 0, nums.length - 1);
    }

    int findMinCore(int[] nums, int left, int right) {
        int mid = left;

        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = (left + right) / 2;
            if (nums[mid] >= nums[left])
                left = mid;
            else if (nums[mid] <= nums[right])
                right = mid;

        }
        return nums[mid];
    }
}
