package section6_矩阵;

/**
 * @description: 旋转图像
 * @author: zhqihang
 * @date: 2024/09/18
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Code03_旋转图像 {

    // 原地修改
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 只需要 旋转替换 1/4 矩阵
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                // 暂存左上角元素
                int tmp = matrix[i][j];
                // 左下角元素赋值给左上角
                matrix[i][j] = matrix[n - 1 - j][i];
                // 右下角元素赋值给左下角
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                // 右上角元素赋值给右下角
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // 暂存的左上角元素赋值给右上角
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }


    // 方法 1 辅助矩阵
    public void rotate1(int[][] matrix) {
        /*
        规律：
            第 i 行 旋转到第 n - 1 - i 列
            第 j 列 旋转到第 j 行
            对于矩阵任意元素，元素位置旋转公式：
                matrix[i][j] --> matrix[j][n - 1 - i]
        需要借助辅助矩阵，以免元素覆盖
         */
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        // int[][] tmp = new int[n][];
        // for (int i = 0; i < n; i++) {
        //     tmp[i] = matrix[i].clone();
        // }

        // 浅拷贝
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }
}
