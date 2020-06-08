/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：


	每次转换只能改变一个字母。
	转换过程中的中间单词必须是字典中的单词。


说明:


	如果不存在这样的转换序列，返回一个空列表。
	所有单词具有相同的长度。
	所有单词只由小写字母组成。
	字典中不存在重复的单词。
	你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class findLadders_126 {
    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId;
    private List<String> idWord;
    private List<Integer>[] edges;

    public findLadders_126() {
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        for (String s: wordList) {
            if (!wordId.containsKey(s)) {
                wordId.put(s, id++);
                idWord.add(s);
            }
        }
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        edges = new ArrayList[idWord.size()];
        for (int i  = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                if (check(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord);
        List<List<String>> res = new ArrayList<>();
        int[] cost = new int[id];
        for (int i = 0; i < id; i++) {
            cost[i] = INF;
        }
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> node = new ArrayList<>();
        node.add(wordId.get(beginWord));
        queue.add(node);
        cost[wordId.get(beginWord)] = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            int last = cur.get(cur.size()-1);
            if (last == dest) {
                List<String> temp = new ArrayList<>();
                for (int n: cur) {
                    temp.add(idWord.get(n));
                }
                res.add(temp);
            } else {
                List<Integer> to = edges[last];
                for (int n: to) {
                    if (cost[n] >= cost[last] + 1) {
                        cost[n] = cost[last] + 1;
                        ArrayList<Integer> temp = new ArrayList<>(cur);
                        temp.add(n);
                        queue.add(temp);
                    }
                }
            }
        }
        return res;
    }

    boolean check(String str1, String str2) {
        int dif = 0;
        for (int i = 0; i < str1.length() && dif < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                dif++;
            }
        }
        return dif == 1;
    }
}

 