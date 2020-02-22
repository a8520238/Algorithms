import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

/**
 * 
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */

class minWindow_76 {
    //滑窗解法
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int require = map.size();
        List<Pair<Integer, Character>> list= new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                list.add(new Pair<Integer, Character> (i, s.charAt(i)));
            }
        }
        int left = 0, right = 0, count = 0;
        int[] flag = {-1, 0, 0};
        Map<Character, Integer> subMap = new HashMap<>();
        while (right < list.size()) {
            char c = list.get(right).getValue();
            subMap.put(c, subMap.getOrDefault(c, 0) + 1);
            if (subMap.get(c).intValue() == map.get(c).intValue()) {
                count++;
            }
            while (left <= right && count == require) {
                c = list.get(left).getValue();
                int start = list.get(left).getKey();
                int end = list.get(right).getKey();
                if (flag[0] == -1 || end - start + 1 < flag[0]) {
                    flag[0] = end - start + 1;
                    flag[1] = start;
                    flag[2] = end;
                }
                subMap.put(c, subMap.get(c) - 1);
                if (subMap.get(c).intValue() < map.get(c).intValue()) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return flag[0] == -1 ? "" : s.substring(flag[1], flag[2]+1);
    }
}
