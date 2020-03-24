/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

	你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
	0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100


示例:

输入: [3,1,5,8]
输出: 167 
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */


//二维dp
class maxCoins_312 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len+2];
        arr[0] = 1;
        System.arraycopy(nums, 0, arr, 1, len);
        arr[len+1] = 1;
        int[][] dp = new int[len+2][len+2];
        for (int i = 1; i < len + 1; i++) {
            dp[i][i] = arr[i-1]*arr[i]*arr[i+1];
        }
        for (int a = 1; a < len; a++) {
            for (int i = 1; i < len + 1 - a; i++) {
                int j = a + i;
                int best = 0;
                for (int m = i; m <= j; m++) {
                    if (dp[i][m-1] + dp[m+1][j] + arr[i-1]*arr[m]*arr[j+1] > best) {
                        best = dp[i][m-1] + dp[m+1][j] + arr[i-1]*arr[m]*arr[j+1];
                    }
                }
                dp[i][j] = best;
            }
        }
        return dp[1][len];
    }
}