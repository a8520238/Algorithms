/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */


import java.util.ArrayList;
import java.util.List;

class wordBreak_139 {
    //暴力递归法，超时
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     return decide(s, 0, wordDict);
    // }
    // private boolean decide (String s, int start, List<String> wordDict) {
    //     boolean res = false;
    //     if (start == s.length()) {
    //         return true;
    //     }
    //     for (int i = start+1; i <= s.length(); i++) {
    //         if (wordDict.contains(s.substring(start, i))) {
    //             res |= decide(s, i, wordDict);
    //         }
    //     }
    //     return res;
    // }
    
    //递归改dp
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        List<Integer> index = new ArrayList<>();
        index.add(0);
        for (int i = 1; i <= dp.length; i++) {
            for (int j : index) {
                if (wordDict.contains(s.substring(j, i))) {
                    dp[i-1] = true;
                    index.add(i);
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}