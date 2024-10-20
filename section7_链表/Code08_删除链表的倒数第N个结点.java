package section7_链表;

/**
 * @description: 删除链表的倒数第N个结点
 * @author: zhqihang
 * @date: 2024/09/26
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Code08_删除链表的倒数第N个结点 {

    // 前后双指针 前指针先走 n 步
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置哨兵节点 方便删除节点（需要知道前驱）
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (n-- != 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
