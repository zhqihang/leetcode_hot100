package section7_链表;

/**
 * @description: 回文链表
 * @author: zhqihang
 * @date: 2024/09/22
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false。
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code03_回文链表 {
    // 回文链表
    // 快慢指针找中点 反转后半部分链表 然后比较两段链表
    public static boolean isPalindrome(ListNode head) {
        // 链表为空 || 单个节点 直接返回 true
        if (head == null || head.next == null) return true;
        // 快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow;
        ListNode cur = slow.next;
        ListNode next = null;
        pre.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 现在链表是 head -> ... -> slow <- ... <- pre
        // 两边往中间对比 不一样就返回false
        ListNode left = head;
        ListNode right = pre;
        boolean ans = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                ans = false;
                break; // 直接返回
            }
            left = left.next;
            right = right.next;
        }
        // 恢复链表 (翻转链表)
        // cur = pre.next;
        // pre.next = null;
        // while (cur != null) {
        //     next = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = next;
        // }
        return ans;
    }
}
