/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//贪心
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] :y[0] - x[0]);
        //注释较为低效
        // List<int[]> Alist = Arrays.asList(people);
        // List<int[]> list = new ArrayList<>(Alist);
        // int size = list.size();
        // for (int i = 0; i < size; i++) {
        //     if (list.get(i)[1] != i) {
        //         list.add(list.get(i)[1], list.get(i));
        //         list.remove(i+1);
        //     }
        // }
        List<int[]> list = new ArrayList<>();
        for (int[] arr: people) {
            list.add(arr[1], arr);
        }
        return list.toArray(new int[0][]);
    }
}