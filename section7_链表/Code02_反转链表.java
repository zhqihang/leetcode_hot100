package section7_链表;

/**
 * @description: 反转链表
 * @author: zhqihang
 * @date: 2024/09/22
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code02_反转链表 {

    // 反转链表
    // 前后指针 遍历反转
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        // 遍历链表
        while (head != null) {
            next = head.next; // 记住下一个位置
            head.next = pre; // 反转指针
            pre = head; // 记住当前位置
            head = next; // head后移
        }
        return pre;
    }
}
