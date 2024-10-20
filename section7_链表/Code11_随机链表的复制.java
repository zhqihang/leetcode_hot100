package section7_链表;

/**
 * @description: 随机链表的复制
 * @author: zhqihang
 * @date: 2024/09/26
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code11_随机链表的复制 {
    // 复制节点，组成新链表
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node next = null;
        // 复制节点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 此时相当于每个节点重复一次

        // 利用这个结构 建立随机指针 random
        cur = head;
        Node copy = null;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random == null ? cur.random.next : null;
            cur = next;
        }
        // 分离链表
        Node ans = head.next; // 新链表的表头 最后返回
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return ans;
    }
}
