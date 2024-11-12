package 牛客面试必刷101;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_006_链表中环的入口节点 {

    // 环的入口节点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 移动指针 注意这里的循环条件
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果相遇 则进行判断
            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
