package 牛客面试必刷101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/11/12
 */
public class Code_010_单链表的排序 {

    public ListNode sortInList (ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] array = list.stream().toArray();
        Arrays.sort(array);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (Object num : array) {
            cur.next = new ListNode((Integer) num);
            cur = cur.next;
        }
        return dummy.next;
    }
}
