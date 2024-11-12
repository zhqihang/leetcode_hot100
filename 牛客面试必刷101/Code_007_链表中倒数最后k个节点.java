package 牛客面试必刷101;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_007_链表中倒数最后k个节点 {

    // 双指针解决
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (k-- != 0) {
            if (fast == null) return null; // 避免空指针异常：k > list.size 的情况
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}
