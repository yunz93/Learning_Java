package LintCode;

/**
 * LintCode 112
 * 删除排序链表中的重复元素
 * Created by Administrator on 2017/7/17 0017.
 */
public class Solution_112 {
    /**
     * @param: ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        // write your code here
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            if (pre != null && pre.val == cur.val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
