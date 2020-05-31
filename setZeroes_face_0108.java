/**编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 */

class setZeroes_face_0108 {
    public void setZeroes(int[][] matrix) {
        boolean[][] f = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !f[i][j]) {
                    for (int m = 0; m < matrix[0].length; m++) {
                        if (matrix[i][m] == 0 && !f[i][m]) {
                            continue;
                        } else {
                            matrix[i][m] = 0;
                            f[i][m] = true;
                        }
                    }
                    for (int m = 0; m < matrix.length; m++) {
                        if (matrix[m][j] == 0 && !f[m][j]) {
                            continue;
                        } else {
                            matrix[m][j] = 0;
                            f[m][j] = true;
                        }
                    }
                    f[i][j] = true;
                }
            }
        }
    }
}