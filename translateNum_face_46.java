/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，
 * ……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。


 */

class translateNum_face_46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        char[] s = str.toCharArray();
        return process(s, 0, s.length);
    }

    public int process(char[] s, int begin, int end) {
        if (begin == end) {
            return 1;
        }
        int n = 0, res = 0;
        for (int i = begin; i < end; i++) {
            n = n * 10 + s[i] - '0';
            if (n < 26) {    
                res += process(s, i + 1, end);
                if (n == 0) {
                    break;
                }
            }
        }
        return res;
    }
}