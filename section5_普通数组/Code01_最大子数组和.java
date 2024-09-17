package section5_普通数组;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/12
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code01_最大子数组和 {
    // 前缀和
    public int maxSubArray(int[] nums) {
        int sum = 0, minSum = 0; // 会有负数出现
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return ans;
    }
    // Kadane算法
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}
