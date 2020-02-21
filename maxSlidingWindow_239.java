

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
 
示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
提示：
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 
进阶：
你能在线性时间复杂度内解决此题吗？

*/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //动态规划
        //每k个为一个块 i% k==0， left记录从左向右最大值， right记录从右向左最大值
        //当滑块滑动到占据两个块时，其最左边right值为左半块最大值，其右侧left值为右侧最大值。取这两个最大值为输出。
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (n == 1) {
            return nums;
        }
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            }
            else {
                left[i] = Math.max(left[i-1], nums[i]);
            }
            int j = n - 1 - i;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            }
            else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }
        int[] out = new int[n-k+1];
        for (int i = 0; i < n-k+1; i++) {
            out[i] = Math.max(right[i], left[i+k-1]);
        }
        return out;
    }
}
// class Solution {
    //双端队列
//     ArrayDeque<Integer> deq = new ArrayDeque<>();
//     int[] nums;
//     private void clean(int i, int k) {
//         // i 代表当前下标， k 代表块的长度
//         //如果为出块的下标，从双端队列移除
//         if (!deq.isEmpty() && deq.getFirst() == i - k) {
//             deq.removeFirst();
//         }
//         // 如果比当前值小，必不可能为大值
//         while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
//             deq.removeLast();
//         }
//     }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if (n * k == 0) {
//             return new int[0];
//         }
//         if (n == 1) {
//             return nums;
//         }
//         this.nums = nums;
//         for (int i = 0; i < k; i++) {
//             clean(i, k);
//             deq.addLast(i);
//         }
//         int[] out = new int[n-k+1];
//         out[0] = nums[deq.getFirst()];
//         for (int i = k; i < n; i++) {
//             clean(i, k);
//             deq.addLast(i);
//             out[i-k+1] = nums[deq.getFirst()];
//         }
//         return out;
//     }
// }