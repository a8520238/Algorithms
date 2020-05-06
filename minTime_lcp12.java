/**
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。

在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。

我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。

示例 1：


输入：time = [1,2,3,3], m = 2

输出：3

解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
 */

class minTime_lcp12 {
    public int minTime(int[] time, int m) { 
        int n = time.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            right += time[i];
        }
        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (check(middle, time, m)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
    public boolean check(int limit, int[] time, int m) {
        int max = 0, ans = 0;
        int res = 1;
        for (int i = 0; i < time.length; i++) {
            if (time[i] > max) {
                max = time[i];
            }
            ans += time[i];
            if (ans - max > limit) {
                i--;
                ans = 0;
                max = 0;
                res++;
            }
            // if (ans + time[i] - max <= limit) {
            //     ans += time[i];
            // } else {
            //     i--;
            //     ans = 0;
            //     max = 0;
            //     res++;
            // }
        }
        return res <= m;
    }
    //     if (m > time.length) {
    //         return 0;
    //     }
    //     int sum = 0;
    //     for (int i = 0; i < time.length; i++) {
    //         sum += time[i];
    //     }
    //     sum /= m;
    //     int max = 0;
    //     int cur = 0;
    //     int start = 0;
    //     int end = 0;
    //     for (int i = 0; i < time.length; i++) {
    //         if (i == time.length-1) {
    //             if (cur == 0) {
    //                 break;
    //             }
    //             else if (cur < max) {
    //                 int nowMax = 0;
    //                 for (int j = start; j <= end; j++) {
    //                     nowMax = Math.max(time[j], nowMax);
    //                 }
    //                 cur -= nowMax;
    //                 max = Math.max(max, cur);
    //             }
    //         }
    //         cur += time[i];
    //         if (cur >= sum) {
    //             int nowMax = 0;
    //             for (int j = start; j <= end; j++) {
    //                 nowMax = Math.max(time[j], nowMax);
    //             }
    //             start = end+1;
    //             cur -= nowMax;
    //             max = Math.max(max, cur);
    //             cur = 0;
    //         }
    //         end++;
    //     }
    //     return max;
    //}
}