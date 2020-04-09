/**给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 */

//旋转矩阵的思想
class rotate_face_01_07 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int n = 0; n < len / 2; n++) {
            int i = n, j = n;
            for (int offset = 0; offset < len - 2 * n - 1; offset++) {
                int temp = matrix[i][j+offset];
                matrix[i][j+offset] = matrix[len-1-n-offset][j];
                matrix[len-1-n-offset][j] = matrix[len-1-n][len-1-n-offset];
                matrix[len-1-n][len-1-n-offset] = matrix[i+offset][len-1-n];
                matrix[i+offset][len-1-n] = temp;
            }
        }
    }
}