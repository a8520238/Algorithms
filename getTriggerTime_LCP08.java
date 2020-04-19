/**
 * 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。

随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。

所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。

根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。

示例 1：


输入： increase = [[2,8,4],[2,5,0],[10,9,8]] requirements = [[2,11,3],[15,10,7],[9,17,12],[8,1,14]]

输出: [2,-1,3,-1]

解释：

初始时，C = 0，R = 0，H = 0

第 1 天，C = 2，R = 8，H = 4

第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0

第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2

剧情 1 和 3 无法触发。
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class getTriggerTime_LCP08 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int C = 0;
        int R = 0;
        int H = 0;
        int[][] results = new int[requirements.length][3];
        for (int i = 0; i < requirements.length; i++) {
            Arrays.fill(results[i], -1);
        }
        int[] res = new int[requirements.length];
        
        PriorityQueue<int[]> minHeap0 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> minHeap1 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> minHeap2 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        
        for (int i = 0; i < requirements.length; i++) {
            // if (requirements[i][0] > 0) {
            //     minHeap0.add(new int[] {requirements[i][0], i});
            // } else {
            //     result[i][0] = 0;
            // }
            minHeap0.add(new int[] {requirements[i][0], i});
            minHeap1.add(new int[] {requirements[i][1], i});
            minHeap2.add(new int[] {requirements[i][2], i});
        }
        
        for (int i = 0; i <= increase.length; i++) {
            while (!minHeap0.isEmpty() && minHeap0.peek()[0] <=  C) {
                int[] temp = minHeap0.poll();
                //System.out.println(0 + "," + Arrays.toString(temp) + i);
                results[temp[1]][0] = i;
            }
            while (!minHeap1.isEmpty() && minHeap1.peek()[0] <=  R) {
                int[] temp = minHeap1.poll();
                //System.out.println(1 + "," + Arrays.toString(temp) + i);
                results[temp[1]][1] = i;
            }
            while (!minHeap2.isEmpty() && minHeap2.peek()[0] <=  H) {
                int[] temp = minHeap2.poll();
                //System.out.println(2 + "," + Arrays.toString(temp) + i);
                results[temp[1]][2] = i;
            }
            if (i < increase.length) {
                C += increase[i][0];
                R += increase[i][1];
                H += increase[i][2];
            }
        }
        for (int i = 0; i < results.length; i++) {
            //System.out.println(Arrays.toString(results[i]));
            if (results[i][0] == -1 || results[i][1] == -1 || results[i][2] == -1) {
                res[i] = -1;
            }
            else {
                res[i] = Math.max(Math.max(results[i][0], results[i][1]), results[i][2]);
            }
        }
        return res;
        // int C = 0;
        // int R = 0;
        // int H = 0;
        // int time = 0;
        // int[] res = new int[requirements.length];
        // Arrays.fill(res, -1);
        //TreeMap<int[], Integer> map = new TreeMap<>((x, y) -> (x[0] != y[0]? (x[0] - y[0]) : (x[1] != y[1] ? (x[1] - y[1]) : x[2] - y[2])));
        // Map<int[], Integer> map = new HashMap<>();
        // for (int i = 0; i < requirements.length; i++) {
        //     map.put(requirements[i], i);
        // }
        // Arrays.sort(requirements, (x, y) -> (x[0] != y[0]? (x[0] - y[0]) : (x[1] != y[1] ? (x[1] - y[1]) : x[2] - y[2])));
        // for (int i = 0; i <= increase.length; i++) {
        //     int start = 0;
        //     int end = requirements.length - 1;
        //     while (start < end) {
        //         int mid = (end - start) / 2 + start;
        //         if (C >= requirements[mid][0]) {
        //             if (R >= requirements[mid][1]) {
        //                 if (H >= requirements[mid][2]) {
        //                     res[map.get(requirements[start])] = time;
        //                     break;
        //                     //start = mid + 1;
        //                 } else {
        //                     end = mid;
        //                 }
        //             } else {
        //                 end = mid;
        //             }
        //         } else {
        //             end = mid;
        //         }
        //     }
            // if (C >= requirements[start][0] && R >= requirements[start][1] && H >= requirements[start][2]) {
            //     res[map.get(requirements[start])] = time;
            // }
            // Iterator iterator = map.keySet().iterator();
            // while (iterator.hasNext()) {
            //     int[] ac = (int[])iterator.next();
            //     if (C >= ac[0] && R >= ac[1] && H >= ac[2]) {
            //         if (res[map.get(ac)] == -1) {
            //             res[map.get(ac)] = time;
            //             break;
            //         }
            //         //break;
            //     }     
            // }

            // if (C >= ac[0] && R >= ac[1] && H >= ac[2]) {
            //     res[map.get(map.firstKey())] = time;
            //     map.pollFirstEntry();
            // }
            // for (int j = 0; j < requirements.length; j++) {
            //     if (C >= requirements[j][0] && R >= requirements[j][1] && H >= requirements[j][2]) {
            //         if (res[j] == -1) {
            //             res[j] = time;
            //             break;
            //         }
            //     }
            // }
        //     if (i < increase.length) {
        //         C += increase[i][0];
        //         R += increase[i][1];
        //         H += increase[i][2];
        //     }
        //     time++;
        // }
        // return res;
        
//         class myTireNode {
//             TreeMap<int[], Integer> map = new TreeMap<>();
//             public addSub(int n) {
                
//             }
//         }
    }
}

//一种二分思想

// class Solution {
//     public int[] getTriggerTime(int[][] increase, int[][] requirements) {
//         int day = 0;
//         int[] ans = new int[requirements.length];
//         //将increase中的三元组的含义变为每一天的属性值
//         for(int i = 1;i<increase.length;i++){
//             increase[i][0] += increase[i-1][0];
//             increase[i][1] += increase[i-1][1];
//             increase[i][2] += increase[i-1][2];
//         }
//         for(int i = 0;i<requirements.length;i++){
//             if(requirements[i][0]==0&&requirements[i][1]==0&&requirements[i][2]==0) ans[i] = 0;
//             else{
//                 int left = 0;
//                 int right = increase.length-1;
//                 //如果最后一天仍不满足，设为-1
//                 if(!(increase[right][0]>=requirements[i][0]&&increase[right][1]>=requirements[i][1]&&increase[right][2]>=requirements[i][2])){
//                     ans[i] = -1;
//                     continue;
//                 }
//                 //二分查找
//                 while(left <right){
//                     int mid = (left+right)/2;
//                     if(!(increase[mid][0]>=requirements[i][0]&&increase[mid][1]>=requirements[i][1]&&increase[mid][2]>=requirements[i][2])){
//                         left = mid+1;
//                     }else{
//                         right = mid;
//                     }
//                 }
//                 ans[i] = left+1;
//             }
//         }
//         return ans;
