package section2_双指针;

import java.util.Map;
import java.util.logging.Level;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/09
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code04_接雨水 {
    // 双指针优化三次遍历
    public int trap(int[] height) {
        int n = height.length;
        // 维护左右两个最大值 和 两个移动的指针
        int l = 1, r = n - 2, lmax = height[0], rmax = height[n - 1];
        int ans = 0;
        while (l <= r) {
            if (lmax < rmax) {
                // 此时可以结算左指针水量
                ans += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l++]); // 更新左侧最大值
            } else {
                // 此时可以结算右指针水量
                ans += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r--]); // 更新右侧最大值
            }
        }
        return ans;
    }
}
