/**
 * 给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：


	每组都有 X 张牌。
	组内所有的牌上都写着相同的整数。


仅当你可选的 X >= 2 时返回 true。

 

示例 1：

输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]


示例 2：

输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。


示例 3：

输入：[1]
输出：false
解释：没有满足要求的分组。


示例 4：

输入：[1,1]
输出：true
解释：可行的分组是 [1,1]


示例 5：

输入：[1,1,2,2,2,2]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[2,2]



提示：


	1 <= deck.length <= 10000
	0 <= deck[i] < 10000
 */


import java.util.HashMap;
import java.util.Map;

//最大公约数法
class hasGroupsSizeX_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        //int maxV = Arrays.stream(deck).max().getAsInt();
        for (int num: deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (temp == 0) {
                temp = entry.getValue();
                continue;
            }
            int now = entry.getValue();
            temp = gcd(now, temp);
            if (temp < 2) {
                return false;
            }
        }
        return temp < 2? false: true;
    }

    public int gcd(int a, int b) {
        return a % b == 0? b: gcd(b, a % b);
    } 
}