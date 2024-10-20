package section7_链表;

/**
 * @description: 环形链表II
 * @author: zhqihang
 * @date: 2024/09/26
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。
 * 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 */
public class Code05_环形链表II {
    // 返回开始入环的第一个节点
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        // 快慢指针找环
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // 慢指针走一步
            fast = fast.next.next; // 快指针走两步
            // 如果快慢指针相遇，此时 分别从头和快指针一起遍历 相遇便是入环节点
            if (slow == fast) {
                ListNode index2 = head;
                ListNode index1 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        // 没有相遇 就是没有环
        return null;
    }
}
