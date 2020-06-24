/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */

import java.util.Arrays;

class threeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int flag = 1000000;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] + nums[i+1] + nums[i+2] >= target) {
                return Math.abs(flag - target) > Math.abs(nums[i] + nums[i+1] + nums[i+2] - target)? nums[i] + nums[i+1] + nums[i+2]: flag;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < target) {      
                if (Math.abs(flag - target) > Math.abs(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] - target)) {
                    flag = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
                }
                continue;
            }
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                if (Math.abs(nums[i] + nums[m] + nums[n] - target) < Math.abs(flag - target)) {
                    flag = nums[i] + nums[m] + nums[n];
                } else if (nums[i] + nums[m] + nums[n] > target) {
                    n--;
                } else {
                    m++;
                }
            }
        }
        return flag;
    }
}