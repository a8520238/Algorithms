/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 */

class jump_45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int res = 0;
        int maxL = 0;
        for (int i = 0; i < length - 1; i++) {
            maxL = Math.max(maxL, i + nums[i]);
            if (i == end) {
                end = maxL;
                res++;
            }
        }
        return res;
    }
}


/**
class Solution {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
*/