package section6_矩阵;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/09/18
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code01_矩阵置零 {
    // 使用标记数组
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // 遍历数组元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        // 遍历列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 标记数组
        boolean[][] flagArr = new boolean[m][n];
        // 遍历数组 找 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果某一个元素为 0 则行列全为 0
                if (matrix[i][j] == 0) {
                    flagArr[i][j] = true;
                }
            }
        }

        // 遍历数组 置 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flagArr[i][j]) {
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
