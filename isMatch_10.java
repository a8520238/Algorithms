/**
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素

所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

	s 可能为空，且只包含从 a-z 的小写字母。
	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

示例 3:
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 */

//动态规划
class isMatch_10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length()-1; j >= 0; j--) {
                boolean first = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j+1 < p.length() && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || first && dp[i+1][j];
                }
                else {
                    dp[i][j] = first && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
//暴力递归
// class Solution {
//     public boolean isMatch(String s, String p) {
//         if (s == null || p == null) {
//             return false;
//         }
//         char[] ss = s.toCharArray();
//         char[] pp = p.toCharArray();
//         return process(ss, pp, 0, 0);
        
//     }
//     private boolean process (char[] s, char[] p, int i, int j) {
//         if (j == p.length) {
//             return i == s.length;
//         }
//         if (j+1 == p.length || p[j+1] != '*') {
//             return i < s.length && (s[i] == p[j] || p[j] == '.') && process(s, p, i+1, j+1);
//         }
//         while (i != s.length && (s[i] == p[j] || p[j] == '.')) {
//             if (process(s, p, i, j+2)) {
//                 return true;
//             }
//             i++;
//         }
//         return process(s, p, i, j+2);
//     }
// }



