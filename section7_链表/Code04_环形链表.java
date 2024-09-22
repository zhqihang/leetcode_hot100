package section7_链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表
 * @author: zhqihang
 * @date: 2024/09/22
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code04_环形链表 {
    // 检查链表是否存在环
    // 方法1 集合
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            // 如果可以加入集合
            if (set.add(head)) {
                head = head.next;
                // 跳过return继续下一轮while
                continue;
            }
            // 没进 if 则表明有环
            return true;
        }
        // 全部走完 就没有环
        return false;
    }

    // 方法2 快慢指针
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
