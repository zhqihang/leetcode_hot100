package section6_矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 螺旋矩阵
 * @author: zhqihang
 * @date: 2024/09/18
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code02_螺旋矩阵 {
    // 定义上下左右四个边界 循环收集
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return null;
        // 定义边界
        int left = 0, right = matrix[0].length - 1, top = 0, bom = matrix.length - 1;
        // 循环遍历收集
        while (true) {
            // 从左向右收集
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (top++ >= bom) break; // 上边界收缩，并且判断是否跳出循环
            // 从上向下收集
            for (int i = top; i <= bom; i++) {
                list.add(matrix[i][right]);
            }
            if (right-- <= left) break; // 右边界收缩，并且判断是否跳出循环
            // 从右往左收集
            for (int i = right; i >= left; i--) {
                list.add(matrix[bom][i]);
            }
            if (bom-- <= top) break; // 下边界收缩
            // 从下向上收集
            for (int i = bom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (left++ >= right) break; // 左边界收缩
        }
        return list;
    }
}
