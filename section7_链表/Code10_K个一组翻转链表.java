package section7_链表;

/**
 * @description: K个一组翻转链表
 * @author: zhqihang
 * @date: 2024/09/26
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code10_K个一组翻转链表 {

    // 翻转链表：双指针探测翻转位置，然后简化为链表翻转
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        if (end == null) return head;

        head = end; // 第一组翻转前的尾指针 是 翻转后的 头指针 也是最终返回值

        reverse(start, end); // 翻转链表
        ListNode lastTeamEnd = start; // 上一组链表的尾指针
        // 还有下一组的话
        while (lastTeamEnd.next != null) {
            // 翻转
            start = lastTeamEnd.next;
            end = teamEnd(start, k);
            if (end == null) return head; // 最后一组只有一个节点 结束
            reverse(start, end);
            lastTeamEnd.next = end; // 上一组的末尾 指向当前组反转后的头
            lastTeamEnd = start; // 更新 继续下一组
        }
        return head;
    }

    // 翻转链表
    private void reverse(ListNode start, ListNode end) {
        end = end.next; // 记录翻转前 尾指针后继
        ListNode pre = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end; // 更新 翻转后 尾指针（start）后继
    }

    // 获取以 head 开头 长度为 k 的子链表的尾节点
    // 获取每一组的最后一个节点
    private ListNode teamEnd(ListNode head, int k) {
        while (--k != 0 && head != null) {
            head = head.next;
        }
        return head;
    }
}
