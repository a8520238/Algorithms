/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。


说明 :


	数组的长度为 [1, 20,000]。
	数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */

import java.util.HashMap;
import java.util.Map;

class subarraySum_560 {
    //正确解法前缀和
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
    //带负数 滑动指针失败
    // public int subarraySum(int[] nums, int k) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     if (nums.length == 1) {
    //         if (nums[0] == k) {
    //             return 1;
    //         } else {
    //             return 0;
    //         }
    //     }
    //     if (k < 0) {
    //         k = -k;
    //         for (int i = 0; i < nums.length; i++) {
    //             nums[i] = -nums[i];
    //         }
    //     }
    //     int left = 0, right = 1;
    //     int sum = nums[0];
    //     int res = 0;
    //     while (left < nums.length && right <= nums.length) {
    //         if (sum < k) {
    //             if (right == nums.length) {
    //                 sum -= nums[left];
    //                 left++;
    //                 continue;
    //             }
    //             sum += nums[right];
    //             right++;
    //         } else if (sum > k) {
    //             sum -= nums[left];
    //             left++;
    //         } else {
    //             res++;
    //             sum -= nums[left];
    //             left++;
    //         }
    //     }
    //     return res;
    // }
}