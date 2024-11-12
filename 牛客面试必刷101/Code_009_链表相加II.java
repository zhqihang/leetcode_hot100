package 牛客面试必刷101;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_009_链表相加II {

    public ListNode addInList (ListNode head1, ListNode head2) {
        // 首先需要反转链表 然后进行运算 需要考虑进位 计算完之后再反转
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode result = new ListNode(-1);
        ListNode tail = result; // 构建链表
        int carry = 0;
        // 循环新增节点： 这三种情况都要新增节点
        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            carry = sum / 10; // 这里也可以是新增进位!
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        return reverseList(result.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
