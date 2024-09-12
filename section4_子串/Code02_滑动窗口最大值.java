package section4_子串;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/12
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code02_滑动窗口最大值 {
    // 每一步中 窗口的最大值
    // 递减单调队列实现：队头最大 收集队头元素
    // 维护一个长度为 k-1 大小的窗口 每次入队一个元素 判断收集答案 出队一个元素

    public static int MAX_N = 100001;
    public static int[] queue = new int[MAX_N];
    public static int h, t; // 头尾指针

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 初始化队列
        h = t = 0;
        int n = nums.length;
        // 维护窗口大小 k-1
        for (int i = 0; i < k - 1; i++) {
            // 入队单调性判断
            // 队列中有元素 && 队尾元素 小于 入队元素
            while (h < t && nums[queue[t - 1]] <= nums[i]) {
                t--; // 队尾元素出队
            }
            // 入队
            queue[t++] = i;
        }
        // 答案数组长度
        int m = n - k + 1;
        int[] ans = new int[m];
        // 遍历填充答案
        for (int l = 0, r = k - 1; l < m; l++, r++) {
            // 入队单调性判断
            // 队列中有元素 && 队尾元素 小于 入队元素
            while (h < t && nums[queue[t - 1]] <= nums[r]) {
                t--; // 队尾元素出队
            }
            // 入队
            queue[t++] = r;
            ans[l] = nums[queue[h]];
            if (queue[h] == l) h++; // 如果队头是 l 失效 出队
        }
        return ans;
    }
}
