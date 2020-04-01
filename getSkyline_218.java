/**
 * 
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。

每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。

例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。

输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。

说明:

	任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
	输入列表已经按左 x 坐标 Li  进行升序排列。
	输出列表必须按 x 位排序。
	输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    //依据左神双treemap 改编单treemap 还是双treemap好想 一个高度，一个位置最高高度
    //其实这里的treemap也可以为堆， 单treemap有点空间换时间了
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[][] alone = new int[buildings.length * 2][3];
        // 上升为0， 下降为2
        for (int i = 0; i < buildings.length; i++) {
            alone[2 * i][0] = buildings[i][0];
            alone[2 * i][1] = buildings[i][2];
            alone[2 * i][2] = 0;
            alone[2 * i + 1][0] = buildings[i][1];
            alone[2 * i + 1][1] = buildings[i][2];
            alone[2 * i + 1][2] = 2;
        }
        
        //高度相同时， 向上的排在向下的前面
        Arrays.sort(alone, (x, y) -> x[0] == y[0]? x[2] == y[2]? y[1] - x[1]: x[2] - 1: x[0] - y[0]);  
        for (int[] arr: alone) {
            System.out.println(Arrays.toString(arr));
        }
        
        int height = 0;
        for (int i = 0; i < alone.length; i++) {
            //上升
            if (alone[i][2] == 0) {
                map.put(alone[i][1], map.getOrDefault(alone[i][1], 0) + 1);
            }
            //下降
            else {
                if (map.get(alone[i][1]) == 1){
                    map.remove(alone[i][1]);
                }
                else {
                    map.put(alone[i][1], map.get(alone[i][1]) - 1);
                }
            }
            //高度上升时生成点
            if (alone[i][1] > height) {
                List<Integer> list = new ArrayList<>();
                list.add(alone[i][0]);
                list.add(alone[i][1]);
                res.add(list);
                height = alone[i][1];
            }
            //高度相等时判断
            else if (alone[i][1] == height) {
                if (alone[i][2] == 2) {
                    if (!map.containsKey(alone[i][1])) {
                        List<Integer> list = new ArrayList<>();
                        if (alone[i][0] == res.get(res.size() - 1).get(0)) {
                            res.remove(res.size() - 1);
                        }
                        list.add(alone[i][0]);
                        list.add(map.isEmpty()? 0: map.lastKey());
                        res.add(list);
                        height = map.isEmpty()? 0: map.lastKey();
                    }
                }
            }
        }
        return res;
    }
}