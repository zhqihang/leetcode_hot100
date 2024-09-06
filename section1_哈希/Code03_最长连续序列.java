package section1_哈希;

import java.util.HashSet;
import java.util.Map;

/**
 * @description: 最长连续子序列
 * @author: zhqihang
 * @date: 2024/09/04
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code03_最长连续序列 {
    // 哈希表
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // 加入集合中 去重
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        // 遍历集合
        for (int num : set) {
            if (set.contains(num - 1)) continue; // 找连续最小的
            // 没有了则开始遍历
            int curNum = num;
            int curLong = 1;
            while (set.contains(curNum + 1)) {
                curNum++;
                curLong++;
            }
            longest = Math.max(longest, curLong);
        }
        return longest;
    }
}
