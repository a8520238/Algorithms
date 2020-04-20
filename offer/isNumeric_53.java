package offer;
public class isNumeric_53 {
    //其实是正则表达式
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                return isFloat(str, 0, i-1) && isInt(str, i+1, str.length - 1);
            }
        }
        return isFloat(str, 0, str.length - 1);
    }
    public boolean isFloat(char[] str, int left, int right) {
        if (left > right) {
            return false;
        }
        if (right - left == 0) {
            return str[left] >= '0' && str[left] <= '9';
        }
        boolean small = true;
        for (int i = left; i <= right; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i != left) {
                    return false;
                }
            }
            else if (str[i] == '.') {
                if (small) {
                    small = false;
                    if (i > 0 && (str[i-1] == '+' || str[i-1] == '-')) {
                        if (i == right) {
                            return false;
                        }
                    }
                    if (i < str.length - 1 && (str[i+1] == '-' || str[i+1] == '+')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
    public boolean isInt(char[] str, int left, int right) {
        if (left > right) {
            return false;
        }
        if (right - left == 0) {
            return str[left] >= '0' && str[left] <= '9';
        }
        for (int i = left; i <= right; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i != left) {
                    return false;
                }
            }
            else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}

/*
public class Solution {    
public boolean isNumeric(char[] str) {        
    String s=String.valueOf(str);        
    return s.matches("[\\+\\-]?(\\d*\\.\\d+|\\d+\\.?)([eE][\\+\\-]?\\d+)?"); 
    
    //或者这样
    String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
}}*/

/*

^ 和 美元符号框定正则表达式，它指引这个正则表达式对文本中的所有字符都进行匹配。
如果省略这些标识，那么只要一个字符串中包含一个数字这个正则表达式就会进行匹配。
如果仅包含 ^ ，它将匹配以一个数字开头的字符串。如果仅包含$ ，则匹配以一个数字结尾的字符串。
[-+]?正负号后面的 ? 后缀表示这个负号是可选的,表示有0到1个负号或者正号 \\d*
\d的含义和[0-9]一样
。它匹配一个数字。后缀 * 指引它可匹配零个或者多个数字。 
(?:\\.\\d*)?(?: …)?表示一个可选的非捕获型分组。
* 指引这个分组会匹配后面跟随的0个或者多个数字的小数点。 
(?:[eE][+\\-]?\d+)?这是另外一个可选的非捕获型分组。
它会匹配一个e(或E)、一个可选的正负号以及一个或多个数字。*/