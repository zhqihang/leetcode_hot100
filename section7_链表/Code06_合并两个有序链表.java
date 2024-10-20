package section7_链表;

import java.util.List;

/**
 * @description: 合并两个有序链表
 * @author: zhqihang
 * @date: 2024/09/26
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code06_合并两个有序链表 {

    // 确定起始节点 然后遍历并且比较 最后若有剩余的链表直接进行连接
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // 确定起始节点
        ListNode start = head1.val > head2.val ? head2 :head1;

        // 两个链表分别维护一个指针 指向待选节点
        ListNode cur1 = start.next;
        ListNode cur2 = start == head1 ? head2 :head1;
        // 新链表的节点
        ListNode pre = start;
        // 遍历 判断 加入新链表 后移
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        // 长链表剩余部分拼接
        pre.next = cur1 != null ? cur1 : cur2;
        return start;
    }
}
