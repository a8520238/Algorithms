/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

package offer;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

// 读完题 想到回溯 dfs 
public class Permutation_27 {
    private StringBuffer buffer = new StringBuffer();
    private ArrayList<String> res = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        dfs(str);
        return res;
    }
    public void dfs(String str) {
        if (str.length() == 0) {
            String s = buffer.toString();
            if (!set.contains(s)) {
                res.add(s);
                set.add(s);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            buffer.append(str.charAt(i));
            dfs(str.substring(0, i) + str.substring(i+1, str.length()));
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}