package 牛客面试必刷101;

/**
 * @description: 反转链表
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_001_反转链表 {

    // 记反双移
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 需要记住前后位置
        ListNode pre = null; // 用于更新指针方向
        ListNode next = null; // 用于遍历移动头指针

        while (head != null) {
            next = head.next; // 先记住下一个位置
            head.next = pre; // 翻转指针
            // 后移两个指针 继续
            pre = head;
            head = next;
        }
        // 此时 head 为 null
        return pre;
    }

    /*
    public ListNode ReverseList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = head.next; // 下一个位置  初始化应放在while循环中
        // 循环遍历链表
        while (head != null) { // 这里永远为真
            head.next = pre; // 翻转指针
            pre = head;
            head = next;
            next = next.next; // 这里会报空指针异常
        }
        return pre;
    }
     */
}
