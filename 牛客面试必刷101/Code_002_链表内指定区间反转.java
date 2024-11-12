package 牛客面试必刷101;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_002_链表内指定区间反转 {

    // 优化算法：一次遍历
    // 固定住区间外的阶段
    public ListNode reverseBetween1 (ListNode head, int m, int n) {
        // 需要虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (m == n) return head;
        int step = n - m + 1; // 反转步数
        // 寻找指针位置
        ListNode pre = dummy; // 第一段的尾巴
        while (m-- != 0) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        // 循环遍历
        while (step-- != 0) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }


    // 模拟出来的算法
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 反转部分链表
        if (m == n) return head;
        int step = n - m + 1; // 反转步数

        // 寻找指针位置
        ListNode pre = null;
        ListNode cur = head;
        while (--m != 0) {
            pre = cur;
            cur = cur.next;
        }
        ListNode tmp1 = cur; // 记住第二段的头（未来第二段的尾巴）用于拼接 2 3
        // 反转
        ListNode next;
        ListNode tmp = null;
        while (step-- != 0) {
            next = cur.next;
            cur.next = tmp;
            tmp = cur;
            cur = next;
        }
        // 拼接 1 2 3 段
        if (pre != null) {
            // 对应 1 为空的情况：从头开始反转 （m=1）
            pre.next = tmp; // 1 2 拼接
            tmp1.next = cur;
            return head;
        } else {
            tmp1.next = cur;
            return tmp;
        }

    }
}
