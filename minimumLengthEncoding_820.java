/***
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 

示例：

输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。

提示：


	1 <= words.length <= 2000
	1 <= words[i].length <= 7
	每个单词都是小写字母 
 */


import java.util.Arrays;

//字典树
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Tire tire = new Tire();
        Arrays.sort(words, (a, b) -> b.length()-a.length());
        int sum = 0;
        for (String word: words) {
            sum += tire.insert(word);
        }
        return sum;
    }

    class Tire {
        tireNode head;
        Tire() {
            head = new tireNode();
        }
        private int insert(String word) {
            tireNode cur = head;
            boolean isNew = false;
            for (int i = word.length()-1; i >= 0; i--) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    isNew = true;
                    cur.children[word.charAt(i) - 'a'] = new tireNode();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            return isNew? word.length()+1: 0;
        }
    }

    class tireNode {
        tireNode[] children = new tireNode[26];
        tireNode() {
        }
    }
}

//错误思想
//if (words == null || words.length == 0) {
        //     return 0;
        // }
        // String last = words[0];
        // StringBuffer stringbuffer = new StringBuffer();
        // stringbuffer.append(last);
        // stringbuffer.append("#");
        // for (int i = 1; i < words.length; i++) {
        //     if (words[i].length() >= last.length()) {
        //         for (int j = 0; j < words[i].length(); j++) {
        //             if (last.equals(words[i].substring(j, words[i].length()))) {
        //                 stringbuffer.delete(stringbuffer.length()-last.length()-1, stringbuffer.length());
        //                 last = words[i];
        //                 stringbuffer.append(last);
        //                 stringbuffer.append("#");
        //                 break;
        //             }
        //             if (j == words[i].length()-1) {
        //                 last = words[i];
        //                 stringbuffer.append(last);
        //                 stringbuffer.append("#");
        //             }
        //         }
        //     }
        //     else {
        //         for (int j = 0; j < last.length(); j++) {
        //             if (words[i].equals(last.substring(j, last.length()))) {
        //                 break;
        //             }
        //             if (j == last.length()-1) {
        //                 last = words[i];
        //                 stringbuffer.append(last);
        //                 stringbuffer.append("#");
        //             }
        //         }
        //     }      
        // }
        // System.out.println(stringbuffer.toString());
        // return stringbuffer.length();