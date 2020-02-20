import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 * 
 * 示例 1:
 * 
 * 输入: "3+2*2" 输出: 7
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 3/2 " 输出: 1
 * 
 * 示例 3:
 * 
 * 输入: " 3+5 / 2 " 输出: 5
 * 
 * 
 * 说明：
 * 
 * 
 * 你可以假设所给定的表达式都是有效的。 请不要使用内置的库函数 eval
 * 
 * 
 * 
 */

class Solution {
    public int calculate(String s) {
        Stack <Integer> stack = new Stack<>();
        char lastSign = '+';
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int temp = s.charAt(i) - '0';
                while (++i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp = temp*10 + (s.charAt(i) - '0');
                }
                i--;
                if (lastSign == '+'){
                    stack.push(temp);
                }
                else if (lastSign == '-') {
                    stack.push(-temp);
                }
                else {
                    stack.push(help(lastSign, temp, stack.pop()));
                }
            }
            else {
                lastSign = s.charAt(i);
            }
        }
        int ans = 0;
        for (int num : stack) {
            ans+= num;
        }
        return ans;
    }
    private int help(char lastSign, int last, int first) {
        if (lastSign == '*') {
            return last*first;
        }
        else {
            return first / last;
        }
    }
}