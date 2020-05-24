/**
 * 给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

 

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。


示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。


示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16
 */

class numberOfSubarrays_1248 {

    //前缀和
    public int numberOfSubarrays(int[] nums, int k) {
        int[] f = new int[nums.length+1];
        f[0] = 1;
        int res = 0, sum = 0;
        for (int n: nums) {
            sum += n & 1;
            f[sum] += 1;
            if (sum >= k) {
                res += f[sum - k];
            }
        }
        return res;
    }

    //滑动窗口
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int count = 0;
    //     int left = 0, right = 0;
    //     int res = 0;
    //     while (right < nums.length) {
    //         if ((nums[right++] & 1) == 1) {
    //             count++;
    //         }
    //         if (count == k) {
    //             int rightC = 0, leftC = 0;
    //             int temp = right;
    //             while (right < nums.length && (nums[right] & 1) == 0) {
    //                 right++;
    //             }
    //             rightC = right - temp;
    //             while ((nums[left] & 1) == 0) {
    //                 leftC++;
    //                 left++;
    //             }
    //             res += (leftC + 1) * (rightC + 1);
    //             left++;
    //             count--;
    //         }
    //     }
    //     return res;
    // }

    //自己想的回溯法失败
    // private int res = 0;
    // public int numberOfSubarrays(int[] nums, int k) {
    //     if (nums == null || nums.length < k) {
    //         return 0;
    //     }
    //     process(nums, 0, 0, 0, k);
    //     return res;
    // }
    // public void process (int[] nums, int left, int right, int count, int k) {
    //     if (count == k) {
    //         res++;
    //         if (nums[left] % 2 != 1) {
    //             process(nums, left+1, right, count, k);
    //         } else {
    //             left++;
    //             count--;
    //         }
    //     }
    //     if (right >= nums.length) {
    //         return;
    //     }
    //     if (nums[right] % 2 == 1) {
    //         process(nums, left, right+1, count+1, k);
    //     } else {
    //         process(nums, left, right+1, count, k);
    //     }
    // }
}