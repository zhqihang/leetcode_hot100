package section1_哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 字母异位词分组
 * @author: zhqihang
 * @date: 2024/09/04
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code02_字母异位词分组 {
    /*
    统计每个字符串的
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 结果集合 字符串：字符串列表
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串
        for (String str : strs) {
            // 计数数组
            int[] counts = new int[26];
            int len = str.length();
            // 统计字母出现次数
            for (int i = 0; i < len; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append('a' + i);
                    sb.append(counts[i]);
                }
            }
            String string = sb.toString(); // 按顺序的字符标志
            // 存在则返回 不存在返回新建的列表
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            list.add(str); // 当前字符串 加入 列表
            map.put(string, list);
        }
        //返回集合的值
        return new ArrayList<>(map.values());
    }
}
