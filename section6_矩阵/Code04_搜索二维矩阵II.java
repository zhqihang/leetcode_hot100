package section6_矩阵;

/**
 * @description: 搜索二维矩阵II
 * @author: zhqihang
 * @date: 2024/09/18
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 *   每行的元素从左到右升序排列。
 *   每列的元素从上到下升序排列。
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code04_搜索二维矩阵II {
    // 利用有序的特性进行优化: 每次从右上角开始找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 右上角坐标
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            // 第 i 行 的元素都小于target 全部排除
            if (matrix[i][j] < target) i++;
            // 第 j 列的数字都大于 target 全部排除
            else j--;
        }
        return false;
    }

}
