package 牛客面试必刷101;

import java.util.ArrayList;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_004_合并k个已排序的链表 {

    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        ListNode listNode = new ListNode(Integer.MIN_VALUE);
        for (ListNode list : lists) {
            listNode = Merge(listNode, list);
        }
        return listNode.next;
    }

    public static ListNode Merge (ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return pHead1 == null ? pHead2 : pHead1;
        // 起始节点
        ListNode start = pHead1.val > pHead2.val ? pHead2 : pHead1;
        ListNode newHead = start;
        // 两个指针 指向待选节点
        ListNode cur1 = start.next;
        ListNode cur2 = start == pHead1 ? pHead2 : pHead1;

        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                start.next = cur2;
                cur2 = cur2.next;
            } else {
                start.next = cur1;
                cur1 = cur1.next;
            }
            start = start.next;
        }
        start.next = cur1 == null ? cur2 : cur1;
        return newHead;
    }
}
