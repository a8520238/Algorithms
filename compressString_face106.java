/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

 示例1:

 输入："aabcccccaaa"
 输出："a2b1c5a3"


 示例2:

 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。


提示：


字符串长度在[0, 50000]范围内。
 */


//水题遍历一遍

//答案写法
class Solution {
    public String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        StringBuilder sb = new StringBuilder().append(S.charAt(0));
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            // 如果i与i-1相同，cnt累加
            if (S.charAt(i) == S.charAt(i - 1)) {
                cnt++;
            } else { 
                // 否则拼接上i-1的次数，从i开始重新计数
                sb.append(cnt).append(S.charAt(i));
                cnt = 1;
            }
        }
        return sb.append(cnt).length() < S.length()? sb.toString(): S;
    }
}
//我的写法
// class Solution {
//     public String compressString(String S) {
//         if (S == null || S.length() == 0) {
//             return S;
//         }
//         String res = "";
//         char now = S.charAt(0);
//         int num = 1;
//         for (int i = 1; i < S.length(); i++) {
//             if (S.charAt(i) == now) {
//                 num++;
//             }
//             else {
//                 res += String.valueOf(S.charAt(i-1)) + num;
//                 num = 1;
//                 now = S.charAt(i);
//             }
//         }
//         res += "" + S.charAt(S.length()-1) + num;
//         return res.length() < S.length() ?res :S;
//     }
// }