package section3_滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 找到字符串中所有字母异位词
 * @author: zhqihang
 * @date: 2024/09/09
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code02_找到字符串中所有字母异位词 {
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // 字符统计数组
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        // 统计字符串 p 的字符数
        for (int i = 0; i < pLen; i++) pCnt[p.charAt(i) - 'a']++;

        ArrayList<Integer> ans = new ArrayList<>();
        if (sLen < pLen) return ans; // 不存在
        // 双指针维护窗口
        int left = 0;
        for (int right = 0; right < sLen; right++) {
            char ch = s.charAt(right);
            sCnt[ch - 'a']++;
            // 右指针指向的不符合要求 [left,right] 全部减一
            while (sCnt[ch - 'a'] > pCnt[ch - 'a']) {
                sCnt[s.charAt(left) - 'a']--;
                left++;
            } // while循环结束 left = right + 1
            if (right - left + 1 == pLen) ans.add(left);
        }
        return ans;
    }
}
