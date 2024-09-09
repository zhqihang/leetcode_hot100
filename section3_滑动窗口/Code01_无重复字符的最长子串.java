package section3_滑动窗口;

import java.util.Arrays;

/**
 * @description: 无重复字符的最长子串
 * @author: zhqihang
 * @date: 2024/09/09
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串  的长度。
 */
public class Code01_无重复字符的最长子串 {

    // 滑动窗口
    // 寻找每个位置结尾的无重复字符子串窗口
    // 右边界来到字符 x 时 左边界 = arrIndex.max(左边界，字符x上一次出现的位置+1)
    public int lengthOfLongestSubstring(String s) {
        // 记录字符第一次出现的位置
        int[] last = new int[256];
        int ans = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        Arrays.fill(last, -1);
        // 遍历 滑动窗口移动
        for (int right = 0; right < s.length(); right++) {
            // 更新左边界
            left = Math.max(left, last[chars[right]] + 1);
            // 更新答案
            ans = Math.max(ans, right - left + 1);
            // 更新字符最近一次出现的位置
            last[chars[right]] = right;
        }
        return ans;
    }
}
