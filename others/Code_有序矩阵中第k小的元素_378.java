package others;

/**
 * @description: 有序矩阵中第k小的元素
 * @author: zhqihang
 * @date: 2024/10/31
 */
public class Code_有序矩阵中第k小的元素_378 {

    // 二维矩阵上进行二分查找
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int nums = n * n; // 矩阵元素个数
        if (nums == 1) return matrix[0][0];
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1); // 中间值
            // 这里需要计算矩阵中小于 mid 的元素个数
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                // 证明 mid 偏小，答案在右
                left = mid + 1;
            } else {
                right = mid; // 答案在左或者就是 mid
            }
        }
        return left;
    }

    // 统计 有序矩阵 小于等于 x 的元素个数
    private int countLessEqual(int[][] matrix, int x) {
        int count = 0;
        int n = matrix.length;
        int row = 0;
        int col = n - 1;
        // 从矩阵的右上角开始统计
        while (row < n && col >= 0) {
            // 如果这个元素满足小于等于x 那么这一行都满足
            if (matrix[row][col] <= x) {
                count += row + 1; // 更新
                row++; // 继续下一行
            } else {
                col--; // 往左缩进
            }
        }
        return count;
    }
}
