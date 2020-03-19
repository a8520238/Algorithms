/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

//标准dp
class maxProduct_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        int maxNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(nums[i]*dpMax[i-1], nums[i]*dpMin[i-1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i]*dpMax[i-1], nums[i]*dpMin[i-1]));
            maxNum = Math.max(dpMax[i], maxNum);
        }

        return maxNum;
    }
}