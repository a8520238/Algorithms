/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。

示例 1：

输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释： 
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。

示例 2：

输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。


提示：


	1 <= words.length <= 1000
	1 <= words[i].length, chars.length <= 100
	所有字符串中都仅包含小写英文字母

 */

import java.util.HashMap;
import java.util.Map;

//典型hash解法，用char[26] On会更少
class countCharacters_1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (String str : words) {
            boolean f = true;
            Map<Character, Integer> word = new HashMap<>();
            for (char c : str.toCharArray()) {
                word.put(c, word.getOrDefault(c, 0)+1);
            }
            for (char c : str.toCharArray()) {
                if (word.get(c) > map.getOrDefault(c, 0)) {
                    f = false;
                    break;
                }
            }
            if (f) {
                ans += str.length();
            }
        }
        return ans;
    }
}