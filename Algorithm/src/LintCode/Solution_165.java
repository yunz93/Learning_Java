package LintCode;

/**
 * LintCode 165
 * 合并两个排序链表
 * Created by Administrator on 2017/7/20 0020.
 */
public class Solution_165 {
    /**
     * @param: ListNode l1 is the head of the linked list
     * @param:ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (null == l1)
            return l2;
        if (null == l2)
            return l1;

        ListNode newHead = null;

        if (l1.val < l2.val) {
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next, l2);
        } else {
            newHead = l2;
            newHead.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }
}
