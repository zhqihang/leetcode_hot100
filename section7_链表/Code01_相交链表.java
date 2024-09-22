package section7_链表;

/**
 * @description: 相交链表
 * @author: zhqihang
 * @date: 2024/09/22
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code01_相交链表 {

    // 双指针后移
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 长链表先走 然后一起后移
        // 遍历 获取链表长度
        int aLen = 0, bLen = 0;
        ListNode a = headA, b = headB;
        while (a.next != null) {
            a = a.next;
            aLen++;
        }
        while (b.next != null) {
            b = b.next;
            bLen++;
        }
        // 长度差值
        if (aLen > bLen) {
            int subLen = aLen - bLen;
            while (subLen-- != 0) {
                headA = headA.next;
            }
        } else {
            int subLen = bLen - aLen;
            while (subLen-- != 0) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
