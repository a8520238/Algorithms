/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True


示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。

 */
class validPalindrome_680 {
    private boolean f = true;
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        int start = 0, end = str.length;
        return help(str, start, end - 1);
    }
    public boolean help(char[] str, int start, int end) {
        while (start < end) {
            if (str[start] == str[end]) {
                start++;
                end--;               
            } else if (f) {
                f = false;
                return help(str, start, end-1) | help(str, start+1, end);
            } else {
                return false;
            }
        }
        return true;
    }
}