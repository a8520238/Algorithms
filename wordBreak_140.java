/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
说明：
分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：
输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：
输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：
输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class wordBreak_140 {

    // 回溯算法 超时
   // public List<String> wordBreak(String s, List<String> wordDict) {
   //     List<String> res = new ArrayList<>();
   //     List<String> list = new ArrayList<>();
   //     callback(s, 0, wordDict, res, list);
   //     return res;
   // }
   // private void callback(String s, int start, List<String> wordDict, List<String> res, List<String> list) {
   //     if (start == s.length()) {
   //         res.add(list.stream().collect(Collectors.joining(" ")));
   //     }
   //     for (int end = start + 1; end <= s.length(); end++) {
           
   //         if (wordDict.contains(s.substring(start, end))) {
   //             list.add(s.substring(start, end));
   //             callback(s, end, wordDict, res, list);
   //             list.remove(list.size()-1);
               
   //         }
           
   //     }
   // }

   //dp
   public List<String> wordBreak(String s, List<String> wordDict) {
       int len = s.length();
       // 状态定义：长度为 i 的子字符串是否符合题意
       boolean[] dp = new boolean[len + 1];
       Set<String> set = new HashSet<>();
       for (String word: wordDict) {
           set.add(word);
       }

       dp[0] = true;
       for (int r = 1; r < len + 1; r++) {
           for (int l = 0; l < r; l++) {
               if (set.contains(s.substring(l, r)) && dp[l]) {
                   dp[r] = true;
                   break;
               }
           }
       }

       List<String> res = new ArrayList<>();
       if (dp[len]) {
           LinkedList<String> queue = new LinkedList<>();
           dfs(s, wordDict, len, set, res, queue, dp);
       }
       return res;
   }

   private void dfs(String s, List<String> wordDict, int end, Set<String> set, 
                List<String> res, LinkedList<String> queue, boolean[] dp) {
       if (end == 0) {
           StringBuffer stringbuffer = new StringBuffer();
           for (String str: queue) {
               stringbuffer.append(str);
               stringbuffer.append(" ");
           }
           stringbuffer.deleteCharAt(stringbuffer.length() - 1);
           res.add(stringbuffer.toString());
           return;
       }
       for (int i = 0; i < end; i++) {
           if (dp[i]) {
               String sub = s.substring(i, end);
               if (set.contains(sub)) {
                   queue.addFirst(sub);
                   dfs(s, wordDict, i, set, res, queue, dp);
                   queue.removeFirst();
               }
           }
       }
   }
}