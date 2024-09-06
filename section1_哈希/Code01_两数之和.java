package section1_哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: zhqihang
 * @date: 2024/09/04
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code01_两数之和 {
    // 哈希表存储 数值和下标  作差 查表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2Index = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 先判断 target - nums[i] 在不在 map
            if (num2Index.containsKey(target - nums[i]))
                return new int[]{i, num2Index.get(target - nums[i])};
            num2Index.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
