package 牛客面试必刷101;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_005_判断链表中是否有环 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        // 注意这里的判断条件：第二个可能会导致空指针异常
        // while (slow.next != null && fast.next.next != null) {
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
