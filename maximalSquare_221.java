/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
 */

class maximalSquare_221 {
    //dp版本
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i-1][j] == '1' && matrix[i][j-1] == '1' && matrix[i-1][j-1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return (int)Math.pow(max, 2);
    }

    //递归版本超时
    // public int maximalSquare(char[][] matrix) {
    //     if (matrix == null || matrix.length == 0) {
    //         return 0;
    //     }
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     int max = 0;
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             if (matrix[i][j] == '1') {
    //                 max = Math.max(max, process(matrix, i, j, 1));
    //             }
    //         }
    //     }
    //     return (int)Math.pow(max, 2);
    // }
    // public int process(char[][] matrix, int i, int j, int res) {
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     if (i + 1 < row && j + 1 < col && matrix[i+1][j] == '1' && matrix[i][j+1] == '1' && matrix[i+1][j+1] == '1') {
    //         return res + Math.min(process(matrix, i+1, j, 1), Math.min(process(matrix, i, j+1, 1), process(matrix, i+1, j+1, 1)));
    //     }
    //     return res;
    // }
}