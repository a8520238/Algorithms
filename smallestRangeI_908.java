/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。

在此过程之后，我们得到一些数组 B。

返回 B 的最大值和 B 的最小值之间可能存在的最小差值。

示例 1：

输入：A = [1], K = 0
输出：0
解释：B = [1]


示例 2：

输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
 */

 //这是一道数学题
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: A) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min - 2 * K < 0? 0: max - min - 2 * K;
    }
}