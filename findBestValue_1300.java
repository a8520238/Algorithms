/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。


 */

import java.util.Arrays;

class findBestValue_1300 {

    //这题官方题解有个二分，有空可以看一下，下面的解法是贪心
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] * (len - i) > target) {
                int res = target / (len - i);
                return Math.abs(target - res*(len - i)) > Math.abs(target - (res+1)*(len-i))? res+1: res;
            } else {
                target -= arr[i];
            }
        }
        return arr[len - 1];
    }
}