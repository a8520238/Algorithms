/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
package offer;
public class FirstNotRepeatingChar_34 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] arr = new int['z' - 'A' + 1];
        char[] s = str.toCharArray();
        for (char c: s) {
            arr[c - 'A'] += 1;
        }
        for (int i = 0; i < s.length; i++) {
            if (arr[s[i] - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }
}