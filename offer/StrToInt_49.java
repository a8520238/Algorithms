/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
package offer;
public class StrToInt_49 {
    public int StrToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        str = str.trim();
        char[] s = str.toCharArray();
        int i = 0;
        int flag = 1;
        int res = 0;
        if (s[0] == '-') {
            flag = -1;
        }
        if (s[0] == '+' || s[0] == '-') {
            i++;
        }
        while (i < s.length) {
            if (s[i] >= '0' && s[i] <= '9') {
                int cur = s[i] -'0';
                if (flag == 1) {
                    if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE/10 && cur > 7) {
                        return 0;
                    }
                }
                if (flag == -1) {
                    if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE/10 && cur > 8) {
                        return 0;
                    }
                }
                res = res*10 + cur;
                i++;
            } else {
                return 0;
            }
        }
        return flag*res;
    }
}