package LintCode;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public class Solution_508 {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            int max = i;
            // 找出未排序序列中的最小值和最大值角标
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min])
                    min = j;
                if (nums[j] > nums[max])
                    max = j;
            }

            swap(nums, min, i);
            i++;
            swap(nums, max, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
