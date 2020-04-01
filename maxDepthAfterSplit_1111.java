/**
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：


	空字符串
	连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
	嵌套，可以记作 (A)，其中 A 是有效括号字符串


类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：


	s 为空时，depth("") = 0
	s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
	s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串


例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。

 

给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。

现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。

返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。

 

示例 1：

输入：seq = "(()())"
输出：[0,1,1,1,1,0]
 */

import java.util.stream.IntStream;

//栈思想 规律思想 Stream
class Solution {
    //方法一 栈思想 奇数深度一组， 偶数一组
    // public int[] maxDepthAfterSplit(String seq) {
    //     //直接使用数组 直接100%
    //     int[] res = new int[seq.length()];
    //     int i = 0;
    //     // 使用list较为低效
    //     //List<Integer> list = new ArrayList<>();
    //     int index = 0;
    //     char[] str = seq.toCharArray();
    //     for (char c: str) {
    //         if (c == '(') {    
    //             index++;
    //             //list.add(index % 2); // 奇数层给B
    //             res[i++] = index % 2;
    //         }
    //         else {
    //             //list.add(index % 2);
    //             res[i++] = index % 2;
    //             index--;
    //         }
    //     }
    //     //list转Integer[]
    //     //System.out.println(Arrays.toString(list.toArray(new Integer[0])));
    //     //list转int[]
    //     //return list.stream().mapToInt(Integer::valueOf).toArray();
    //     return res;
    // }
    //找规律思想 下标为奇数的左括号给A， 下标为奇数的右括号给B，右括号相反
    public int[] maxDepthAfterSplit(String seq) {
        //一行30%
        return IntStream.range(0, seq.length()).map(i -> (i & 1)^(seq.charAt(i) == '('? 1: 0)).toArray();

        //javascript 流写法
        // return seq.split("").map((value, index) => index & 1 ^ (value === '('));
    }
}