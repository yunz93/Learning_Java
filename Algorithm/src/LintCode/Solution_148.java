package LintCode;

/**
 * LintCode 148
 * 颜色排序
 * 要求一次遍历数组，空间复杂度为常数
 * 一个前指针begin，一个中指针current，一个后指针end，current指针遍历整个数组序列，当
 * current指针所指元素为0时，与begin指针所指的元素交换，而后current++，begin++ ；
 * current指针所指元素为1时，不做任何交换（即球不动），而后current++ ；
 * current指针所指元素为2时，与end指针所指的元素交换，而后，current指针不动，end-- 。
 * Created by Administrator on 2017/7/28 0028.
 */
public class Solution_148 {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 0) {
            return;
        }

        int left = 0;
        int cur = 0;
        int right = nums.length - 1;

        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, left, cur);
                left++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            }
        }
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
