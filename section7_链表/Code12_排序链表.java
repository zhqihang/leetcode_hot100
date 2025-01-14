package section7_链表;

/**
 * @description: 排序链表
 * @author: zhqihang
 * @date: 2024/09/26
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 时间复杂度 nlogn 常数空间 下完成
 */
public class Code12_排序链表 {

    // 返回升序排列的链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 快慢指针 寻找中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表分为两个部分
        ListNode temp = slow.next;
        slow.next = null;

        // 递归
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;

        // 排序
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
