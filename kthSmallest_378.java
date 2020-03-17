/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。


说明: 
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */


//二分法
class kthSmallest_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix[0].length-1];
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = search(matrix, mid);
            if (k <= count) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
    private int search(int[][] matrix, int mid) {
        int i = 0;
        int j = matrix[0].length-1;
        int count = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= mid) {
                count += j+1;
                i++;
            }
            else {
                j--;
            }
        }
        return count;
    }
}