/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

//贪心 99% On
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        //int right = 0;
        //int max = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[left]) {
                res += count(height, left, i);
                left = i;
            }
        }
        if (left != height.length - 1) {
            int[] rHeight = new int[height.length - left];
            for (int i = 0; i < rHeight.length; i++) {
                rHeight[i] = height[height.length - i -1];
            }
            res += trap(rHeight);
        }
        return res;
    }
    public int count(int[] arr, int left, int right) {
        int max = Math.min(arr[left], arr[right]);
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res += (max - arr[i]);
        }
        //System.out.println(left + "," + right + "," + res);
        return res;
    }
}

//别人的题解 创建每个点左边最大， 右边最大， 类似动态规划
// public int trap2(int[] height) {
//         if (height == null || height.length < 3) {
//             return 0;
//         }
//         int sum = 0;
//         //left[i]表示第i列左边的最高的列值,包含
//         int[] left = new int[height.length];
//         left[0] = height[0];

//         for (int i = 1; i < height.length; i++) {
//             left[i] = left[i - 1] > height[i] ? left[i - 1] : height[i];
//         }

//         int[] right = new int[height.length];
//         right[height.length - 1] = height[right.length - 1];
//         for (int i = height.length - 2; i >= 0; i--) {
//             right[i] = right[i + 1] > height[i] ? right[i + 1] : height[i];
//         }
//         for (int i = 1; i < height.length - 1; i++) {
//             sum += Math.min(left[i], right[i]) - height[i];

//         }
//         return sum;

//     }
