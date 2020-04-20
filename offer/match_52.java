/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
package offer;
public class match_52 {
    //dp版本
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        int len1 = str.length;
        int len2 = pattern.length;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[len1][len2] = true;
        for (int i = len1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                boolean first = i < len1 && (str[i] == pattern[j] || pattern[j] == '.');
                if (j + 1 < len2 && pattern[j+1] == '*') {
                    dp[i][j] = dp[i][j+2] || first && dp[i+1][j];
                }
                else {
                    dp[i][j] = first && dp[i+1][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
    //递归版本
    /*
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
       char[] str1 = str;
       char[] str2 = pattern;
       return dfs(str1, str2, 0, 0);
    }
    public boolean dfs(char[] str1, char[] str2, int index1, int index2) {
        while (index1 < str1.length && index2 < str2.length) {
            if (index2 + 1 < str2.length && str2[index2 + 1] == '*') {
                while (index1 < str1.length && str1[index1] == str2[index2] || str2[index2] == '.') {
                    if (dfs(str1, str2, index1, index2 + 2)) {
                            return true;
                    }
                   index1++;
                } */
                /*
                if (str2[index2] != '.') {
                    for (int temp = str1[index1]; index1 < str1.length && str1[index1] == temp; index1++) {
                        if (dfs(str1, str2, index1, index2 + 2)) {
                            return true;
                        }
                    }
                } else {
                    while (index1 < str1.length) {
                        if (dfs(str1, str2, index1, index2 + 2)) {
                            return true;
                        }
                        index1++;
                    }
                }*/ /*
            } else {
                 if (str1[index1] == str2[index2] || str2[index2] == '.') {
                    index1++;
                    index2++;
                }
            }
        }
        if (index1 == str1.length) {
            if (index2 + 1 < str2.length && str2[index2 + 1] == '*') {
                index2 += 2;
            }
        }
        if (index1 == str1.length && index2 == str2.length) {
            return true;
        }
        return false;
    }*/
}