/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。


两个字符串完全匹配才算匹配成功。

说明:


	s 可能为空，且只包含从 a-z 的小写字母。
	p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。


示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。


示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。


示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".


示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输入: false
 */


//动态规划 巨恶
class isMatch_44 {
    //动态规划
    public boolean isMatch(String s, String p) {
        if (s.equals(p) || p.equals("*")) {
            return true;
        }
        if (s.isEmpty() || p.isEmpty()) {
            return false;
        }
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < p.length()+1; i++) {
            if (p.charAt(i-1) == '*') {
                int j = 1;
                while (dp[i-1][j-1] == false && j < s.length()+1) {
                    j++;
                }
                dp[i][j-1] = dp[i-1][j-1];
                while (j < s.length()+1) {
                    dp[i][j++] = true;
                }
            }
            else if (p.charAt(i-1) == '?') {
                for (int j = 1; j < s.length()+1; j++) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
            else {
                for (int j =1; j < s.length()+1; j++) {
                    dp[i][j] = dp[i-1][j-1] && p.charAt(i-1) == s.charAt(j-1);
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}

// class Solution {
//     //递归版本超时
//     public boolean isMatch(String s, String p) {
//         if (s == null || p == null) {
//             return false;
//         }
//         return match(s, p, 0, 0);
//     }
//     private boolean match (String s, String p, int i, int j) {
//         if (j == p.length()) {
//             return i == s.length();
//         }
//         if (p.charAt(j) != '*') {
//             return i != s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') && match(s, p, i+1, j+1);
//         }
//         if (j == p.length()-1) {
//             return true;
//         }
//         if (p.charAt(j+1) == '*') {
//             return match(s, p, i, j+1);
//         }
//         while (i < s.length()) {
//             if (match(s, p, i, j+1)) {
//                 return true;
//             }
//             i++;
//         }
//         return false;
//     }
//     // private boolean match (String s, String p, int i, int j) {
//     //     if (j == p.length()) {
//     //         return i == s.length();
//     //     }
//     //     if (i == s.length()) {
//     //         while (j < p.length()) {
//     //             if (p.charAt(j) == '*') {
//     //                 j++;
//     //             }
//     //             else {
//     //                 break;
//     //             }
//     //         }
//     //         return j == p.length();
//     //     }
//     //     if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
//     //         return match(s, p, i+1, j+1);
//     //     }
//     //     else if (p.charAt(j) == '*') {
//     //         if (j == p.length()-1) {
//     //             return true;
//     //         }
//     //         while (i < s.length()) {
//     //             if (match(s, p, i, j+1)) {
//     //                 return true;
//     //             }
//     //             i++;
//     //         }
//     //     }
//     //     return false;
//     // }
// }