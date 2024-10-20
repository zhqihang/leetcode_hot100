package section7_链表;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/26
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code07_两数相加 {

    // 小数在链表头 需要考虑进位
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        // 答案链表
        ListNode ans = null;
        ListNode cur = null;
        int carry = 0; // 进位
        // 遍历链表
        for (int sum, val;
             h1 != null || h2 != null;
             h1 = h1 == null ? null : h1.next, h2 = h2 == null ? null : h2.next) {
            sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            // 当前位置的数
            val = sum % 10;
            // 判断进位
            carry = sum / 10;

            // 加入新链表
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        // 判断最后一位是否存在进位
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }
}
