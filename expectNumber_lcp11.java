/**
 * 某互联网公司一年一度的春招开始了，一共有 n 名面试者入选。每名面试者都会提交一份简历，公司会根据提供的简历资料产生一个预估的能力值，数值越大代表越有可能通过面试。

小 A 和小 B 负责审核面试者，他们均有所有面试者的简历，并且将各自根据面试者能力值从大到小的顺序浏览。由于简历事先被打乱过，能力值相同的简历的出现顺序是从它们的全排列中等可能地取一个。现在给定 n 名面试者的能力值 scores，设 X 代表小 A 和小 B 的浏览顺序中出现在同一位置的简历数，求 X 的期望。

提示：离散的非负随机变量的期望计算公式为 。在本题中，由于 X 的取值为 0 到 n 之间，期望计算公式可以是 。

示例 1：


输入：scores = [1,2,3]

输出：3

解释：由于面试者能力值互不相同，小 A 和小 B 的浏览顺序一定是相同的。X的期望是 3 。
 */
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int expectNumber(int[] scores) {
        //看题解 每个相同能力值无论多少个最终的 期望都为1，故转化为多少个不同的值
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < scores.length; i++) {
            set.add(scores[i]);
        }
        return set.size();
    }
}