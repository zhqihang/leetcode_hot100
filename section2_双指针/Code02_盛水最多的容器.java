package section2_双指针;

/**
 * @description: 盛水最多的容器
 * @author: zhqihang
 * @date: 2024/09/06
 */
public class Code02_盛水最多的容器 {

    // 双指针
    public int maxArea(int[] height) {
        int ans = 0;
        // 左右指针
        for (int l = 0, r = height.length - 1; l < r;) {
            // 更新结果                较小的高（height[l], height[r]）乘以 底
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            // 移动小的指针
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
    // 左右指针向中间遍历，哪条线短就移动哪条的指针，移动之间计算面积更新答案
    public int maxArea1(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 计算面积
            int area = (right - left) * Math.min(height[left], height[right]);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
