package LintCode;

/**
 * Lintcode 451 两两交换链表中的节点
 * 简单的递归即可求解
 * Created by Administrator on 2017/8/7 0007.
 */
public class Solution_451 {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode cur = head;

        if (cur == null || cur.next == null) {
            return cur;
        }

        ListNode next = cur.next;
        ListNode nextHead = next.next;

        next.next = cur;
        cur.next = swapPairs(nextHead);

        return next;
    }
}
