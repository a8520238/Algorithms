import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: words = ["oath","pea","eat","rain"] and board = [ ['o','a','a','n'],
 * ['e','t','a','e'], ['i','h','k','r'], ['i','f','l','v'] ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明: 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */

 //解法 字典树加上回溯算法
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TireTree tree = new TireTree();
        for (String s :words) {
            tree.insert(s);
        }
        Set<String> set = new HashSet<>();
        boolean[][] f = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(set, f, board, i, j, tree.root);
            }
        }
        return new ArrayList<String>(set);
    }
    private void find(Set<String> set, boolean[][] f, char[][] board, int i, int j, tireNode root) {
        if (i<0||i> board.length-1||j<0||j>board[0].length-1||f[i][j]) {
            return;
        }
        tireNode cur = root.child[board[i][j]-'a'];
        if (cur == null) {
            return;
        }
        if (cur.isLeap) {
            set.add(cur.val);
        }
        f[i][j] = true;  
        find(set, f, board, i-1, j, cur);
        find(set, f, board, i+1, j, cur);
        find(set, f, board, i, j-1, cur);
        find(set, f, board, i, j+1, cur);
        f[i][j] = false;
    }
    class TireTree {
        tireNode root = new tireNode();
        private void insert(String s) {
            tireNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.child[c-'a'] == null) {
                    cur.child[c-'a'] = new tireNode();
                    cur = cur.child[c-'a'];
                }
                else {
                    cur = cur.child[c-'a'];
                }
            }
            cur.val = s;
            cur.isLeap = true;
        }

    }
    class tireNode {
        String val;
        tireNode[] child = new tireNode[26];
        boolean isLeap = false;
        tireNode() {
        }   
    }
}