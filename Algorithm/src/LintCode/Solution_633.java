package LintCode;

/**
 * LintCode 633 Find the Duplicate Number
 * 想都想不到，找数组重复值的问题和找有环链表的环起点的题目竟然一个解决思路
 * Created by Administrator on 2017/8/9 0009.
 */
public class Solution_633 {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
