/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true

说明:


	你可以假设所有的输入都是由小写字母 a-z 构成的。
	保证所有输入均为非空字符串
 * 
 * 
 */
//前缀树
class Trie {

    private tireNode head;
        
    class tireNode {
        boolean isLeaf = false;
        //char value;
        tireNode[] tireArr;
        tireNode() {
            tireArr = new tireNode[26];
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        this.head = new tireNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] str = word.toCharArray();
        tireNode cur = head;
        for (char c : str) {
            if (cur.tireArr[c-'a'] == null) {
                cur.tireArr[c-'a'] = new tireNode();
                //cur.tireArr[c-'a'].value = c;
            }
            cur = cur.tireArr[c-'a'];
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] str = word.toCharArray();
        tireNode cur = head;
        for (char c : str) {
            if (cur.tireArr[c-'a'] == null) {
                return false;
            }
            cur = cur.tireArr[c-'a'];
        }
        return cur.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] str = prefix.toCharArray();
        tireNode cur = head;
        for (char c : str) {
            if (cur.tireArr[c-'a'] == null) {
                return false;
            }
            cur = cur.tireArr[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */