package section4_子串;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/12
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class Code03_最小覆盖子串 {
    /*
    思路:
    遍历 tar 字符数组 维护一个 “欠债表”
    整型数组和 总欠债 即 tar 的长度
    先向右探测 满足 tar 之后，记录此时长度  然后试探左侧是否可以缩短
    欠债表 记账 还账都会更新 记账用于尝试是否能够缩短左侧
    如果 此时 cnts[sChar[l]] 大于0 表示 这个字母是多余的 可以淘汰
    左移左指针 继续判断
     */
    public String minWindow(String str, String tar) {
        char[] strChar = str.toCharArray();
        char[] tarChar = tar.toCharArray();
        // 维护一个欠债表
        int[] cnts = new int[256];
        // 遍历更新欠债表
        for (char ch : tarChar) {
            cnts[ch]--;
        }
        int len = Integer.MAX_VALUE;
        int start = 0;
        // 左边界 l 右边界 r
        // 向右探测
        for (int l = 0, r = 0, debt = tarChar.length; r < strChar.length; r++) {
            // 还款 ++是一定会记账或者还账（记账用于收缩左边界）
            if (cnts[strChar[r]]++ < 0) debt--;
            // 此时满足tar 但是可能不是最短的 所以尝试收缩左边界
            if (debt == 0) {
                while (cnts[strChar[l]] > 0) {
                    cnts[strChar[l]]--;
                    l++;
                }
                // 记录起始点
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }
}
