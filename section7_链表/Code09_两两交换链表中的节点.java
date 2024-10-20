package section7_链表;

/**
 * @description: 两两交换链表中的节点
 * @author: zhqihang
 * @date: 2024/09/26
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code09_两两交换链表中的节点 {

    // 遍历 指针交换
    public ListNode swapPairs(ListNode head) {
        // 需要知道前驱 所以新建哨兵节点
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy; // 哨兵节点
        ListNode node1 = head;

        // 至少有两个节点
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            // 交换指针方向
            node0.next = node2;
            node2.next = node1;
            node1.next = node3;
            // 后移继续操作
            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
    }
}
