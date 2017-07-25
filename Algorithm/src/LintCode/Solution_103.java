package LintCode;

/**
 * LintCode 103
 * 判断一个链表是否带环，而且找到环入口节点
 * 判断链表带环，经典的做法就是快慢指针，快指针一次走两步，慢指针一次走一步
 * 两指针同时从表头出发，如果能相遇，则存在环
 * 判断环入口，则是简单数学问题
 * 见：http://blog.csdn.net/bitboss/article/details/51648030
 * 接下来将fast指针指向表头，一次走一步，快慢指针再次相遇的点
 * 即为环入口
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution_103 {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null)
            return null;

        // write your code here
        ListNode fast = head;
        ListNode slow = head;

        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
