package section5_普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/16
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code02_合并区间 {
    /*
    思路:
        先按第一个维度(区间左边界)对区间进行排序
        然后逐个加入链表
        加入时判断 此区间的左边界 和 链表最后一个区间的右边界 是否重叠
        不重叠 加入链表 继续
        重叠 更新最后一个区间的右边界(取最大值--考虑区间包含) 不加入链表 继续
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];});
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            // 区间左右边界
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < l)
                list.add(new int[]{l, r});
            else
                // 合并操作
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], r);
        }
        return list.toArray(new int[list.size()][2]);
    }

}
