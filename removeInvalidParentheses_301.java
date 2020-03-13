import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
说明: 输入可能包含了除 ( 和 ) 以外的字符。
示例 1:
输入: "()())()"
输出: ["()()()", "(())()"]
示例 2:
输入: "(a)())()"
输出: ["(a)()()", "(a())()"]
示例 3:
输入: ")("
输出: [""]
 */


//回溯加括号判断
class removeInvalidParentheses_301 {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = 0;
        for (char c : str) {
            if (c == '(') {
                left++;
            }
            else if (c == ')') {
                if (left > 0) {
                    left--;
                }
                else {
                    right++;
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        dfs(s, 0, 0, 0, left, right, buffer);
        return new ArrayList<String> (set);
    }
    private void dfs(
                    String s,
                    int index,
                    int leftCount,
                    int rightCount,
                    int leftDelete,
                    int rightDelete,
                    StringBuffer buffer) 
    {
        if (index == s.length()) {
            if (leftDelete == 0 && rightDelete == 0) {
                this.set.add(buffer.toString());
            }
        }
        else {
            if ((s.charAt(index) == '(' && leftDelete > 0) || (s.charAt(index) == ')' && rightDelete > 0)) {
                dfs(s, 
                    index+1, 
                    leftCount, 
                    rightCount, 
                    s.charAt(index) == '('?leftDelete-1:leftDelete,
                    s.charAt(index) == ')'?rightDelete-1:rightDelete,
                    buffer);
            }
            buffer.append(s.charAt(index));
            if (s.charAt(index) != '(' && s.charAt(index) != ')') {
                dfs(s, index+1, leftCount, rightCount, leftDelete, rightDelete, buffer);
            } else if (s.charAt(index) == '(') {
                dfs(s, index+1, leftCount+1, rightCount, leftDelete, rightDelete, buffer);
            } else if (leftCount > rightCount) {
                dfs(s, index+1, leftCount, rightCount+1, leftDelete, rightDelete, buffer);
            }
            buffer.deleteCharAt(buffer.length()-1);
        }
    }
}
