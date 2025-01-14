package section2_双指针;

/**
 * @description: 移动零
 * @author: zhqihang
 * @date: 2024/09/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code01_移动零 {
    // 左右指针
    // 左指针指向当前已经处理好的序列的尾部
    // 右指针指向待处理序列的头部
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
