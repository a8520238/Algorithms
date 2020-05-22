/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。

 

示例 1：

输入：s = "eleetminicoworoep"
输出：13
解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。

 */

import java.util.Arrays;

class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int status = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                status ^= 1;
            } else if (s.charAt(i) == 'e') {
                status ^= (1 << 1);
            } else if (s.charAt(i) == 'i') {
                status ^= (1 << 2);
            } else if (s.charAt(i) == 'o') {
                status ^= (1 << 3);
            } else if (s.charAt(i) == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                res = Math.max(res, i - pos[status] + 1);
            } else {
                pos[status] = i + 1;
            }
        }
        return res;
    }
}