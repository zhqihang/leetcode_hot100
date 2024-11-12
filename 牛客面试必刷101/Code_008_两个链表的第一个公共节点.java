package 牛客面试必刷101;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_008_两个链表的第一个公共节点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 长链表先走长度差 然后一起向后走 相等返回
        int len1 = 0, len2 = 0;
        ListNode temp1 = pHead1, temp2 = pHead2;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        ListNode longList = len1 >= len2 ? pHead1 : pHead2;
        ListNode shortList = len1 >= len2 ? pHead2 : pHead1;
        int sub = Math.abs(len1 - len2); // 多出来的
        while (sub-- != 0) {
            longList = longList.next;
        }
        while (shortList != null && longList != null) {
            if (shortList == longList) return shortList;
            shortList = shortList.next;
            longList = longList.next;
        }
        return null;
    }
}
