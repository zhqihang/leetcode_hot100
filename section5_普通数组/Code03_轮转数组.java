package section5_普通数组;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/16
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code03_轮转数组 {

    // 原地算法
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k= k % n; // 确保 k 小于数组长度
        int count = gcd(k, n); // 最小的轮准次数
        for (int start = 0; start < count; start++) {
            int cur = start;
            int pre = nums[start];
            do {
                int next = (cur + k) % n;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
            } while (start != cur);
        }
    }
    // 最大公约数：欧几里得算法（不断取余数，直到其中的一个数变为0，最终的非零数即为最大公约数）
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    // 尾巴截断拼接到头
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        // 轮转次数
        int step = k % n;
        int[] newArr = new int[n];
        // 处理需要移动的数组
        for (int i = 0; i < step; i++) {
            newArr[i] = nums[n - step + i];
        }
        // 处理剩余的数组
        for (int i = step; i < n; i++) {
            newArr[i] = nums[i - k];
        }
        // 复制到原来的 nums
        System.arraycopy(newArr, 0, nums, 0, n);

    }
}
