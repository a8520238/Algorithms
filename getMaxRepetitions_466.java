/**
 * 难度
困难

63





由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 
示例：
输入：
s1 ="acb",n1 = 4
s2 ="ab",n2 = 2
 */

import java.util.HashMap;
import java.util.Map;

class getMaxRepetitions_466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || n1 == 0 || len2 == 0 || n2 == 0) {
            return 0;
        }
        Map<Integer, int[]> map = new HashMap<>();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] first = null;
        int[] second = null;
        int counts1 = 0;
        int counts2 = 0;
        int index = 0;
        while (true) {
            counts1++;
            for (int i = 0; i < str1.length; i++) {
                if (str2[index] == str1[i]) {
                    index++;
                    if (index == str2.length) {
                        index = 0;
                        counts2++;
                    }
                }
            }
            if (counts1 == n1) {
                return counts2 / n2;
            }
            if (map.containsKey(index)) {
                first = map.get(index);
                second = new int[] {counts1, counts2};
                break;
            } else {
                map.put(index, new int[] {counts1, counts2});
            }
        }
        int res = first[1] + (n1 - first[0]) / (second[0] - first[0]) * (second[1] - first[1]);
        int rest = (n1 - first[0]) % (second[0] - first[0]);

        for (int i = 0; i < rest; i++) {
            for (int j = 0; j < str1.length; j++) {
                if (str1[j] == str2[index]) {
                    index++;
                    if (index == str2.length) {
                        index = 0;
                        res++;
                    }
                }
            }
        }
        
        return res / n2;
    }
}