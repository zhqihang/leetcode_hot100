package section5_普通数组;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/17
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code05_缺失的第一个正数 {
     // 双指针
    public int firstMissingPositive(int[] arr) {
        // [1, 2, 3, 4,...]
        //  0  1  2  3 ...
        // l的左边，都是做到 i位置上放着 i+1 的区域
        // 永远盯着l位置的数字看，看能不能扩充(l++)
        int l = 0;
        // 1. [r....]垃圾区
        // 2. 最好的状况下，认为1~r是可以收集全的，每个数字收集1个，不能有垃圾
        // 有垃圾呢？预期就会变差(r--)
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                //          小于l  大于此时预期(只能)      要去的位置已经有了（重复）
                // 出现垃圾 交换 扩大垃圾区
                swap(arr, l, --r);
            } else {
                // arr[arr[l] - 1] != arr[l] 的情况 只交换 继续看交换过来的数
                swap(arr, l, arr[l] - 1); // 时间复杂度O(n)，额外空间复杂度O(1)
            }
        }
        return l + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
