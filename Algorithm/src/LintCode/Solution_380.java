package LintCode;

/**
 * LintCode 380
 * 两个链表的交叉
 * 求两个交叉链表的首个公共节点
 * 先求出两条链表的长度，然后稍长的那条先走若干步，使得两条链表长度一致
 * 再同时遍历，相等的该节点即为首个公共节点
 * Created by Administrator on 2017/7/17 0017.
 */
public class Solution_380 {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (null == headA || null == headB) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        int na = 0;
        int nb = 0;

        while (a != null) {
            na++;
            a = a.next;
        }

        while (b != null) {
            nb++;
            b = b.next;
        }

        ListNode a2 = headA;
        ListNode b2 = headB;

        if (na > nb) {
            for (int i = 0; i < (na - nb); i++) {
                a2 = a2.next;
            }
        } else {
            for (int i = 0; i < (nb - na); i++) {
                b2 = b2.next;
            }
        }

        while (a2 != null || b2 != null) {
            if (a2 == b2) {
                return a2;
            }
            a2 = a2.next;
            b2 = b2.next;
        }

        return null;
    }
}
