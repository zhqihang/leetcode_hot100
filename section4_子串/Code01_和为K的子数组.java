package section4_子串;

import java.util.HashMap;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/09
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code01_和为K的子数组 {

    public int subarraySum(int[] nums, int k) {
        // 前缀和--出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 前缀和为0的次数为1
        int ans = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            // 0 --> i 的前缀和 减去 k
            // 如果出现过 证明中间有数组和是 k
            ans += map.getOrDefault(sum - k, 0); // 更新答案
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
