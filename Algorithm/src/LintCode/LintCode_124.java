package LintCode;

import java.util.HashSet;

/**
 * lintcode 124
 * 最长连续序列
 * 给定一组无序数组，要求在O(n)时间内找出最长连续序列（乱序）
 * 要求时间复杂度，所以先排序再dp肯定是不行的
 * 遍历的时间复杂度为O(n)，所以要求其他操作必须是O(1)复杂度的
 * 要想在数组中以O(1)复杂度查找数字，自然而然想到HashSet
 */

public class LintCode_124 {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<num.length; i++) {
            set.add(num[i]);
        }

        int longest = 0;

        for (int i=0; i<num.length; i++) {
            int down = num[i] - 1;
            while(set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = num[i] + 1;
            while(set.contains(up)) {
                set.remove(up);
                up++;
            }

            longest = Math.max(longest, up - down - 1);
        }
        return longest;
    }
}
