import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[3,3]] 输出: 3 解释: ^ | | o | o | o +-------------> 0 1 2 3 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] 输出: 4 解释: ^ | | o | o o | o | o o
 * +-------------------> 0 1 2 3 4 5 6
 */

//斜率 bigcount 辗转相除法 存分数分别存分子分母

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0, duplicate = 0;    
            int x = points[i][0];
            int y = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x == x2 && y == y2) {
                    duplicate++;
                    continue;
                }
                int g = gcd(x2 - x, y2 - y);
                int k_up = (x2 - x) / g;
                int k_down = (y2 - y) / g;
                String key = k_up + "@" + k_down;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int x, int y) {
        return y == 0? x: gcd(y, x % y);
    }
}

//别人的优秀解法
// class Solution {
//     public int maxPoints(int[][] points) {
//         //先对点进行排序，将横坐标纵坐标差值较小的点排在前面
//         Arrays.sort(points, new Comparator<int[]>(){
//             public int compare(int[] arr1, int[] arr2){
//                 return Math.abs(arr1[0] - arr1[1]) - Math.abs(arr2[0] - arr2[1]);
//             }
//         });
//         if(points == null || points.length == 0)
//             return 0;
//         int len = points.length;
//         if(len < 3)
//             return len;
//         int res = 0;
//         for(int i = 1; i < len; i++){
//             long x = points[i][0];
//             long y = points[i][1];
//             long dx = x - points[i - 1][0];
//             long dy = y - points[i - 1][1];
//             int count = 0;
//             if(dx == 0 && dy == 0){
//                 for(int j = 0; j < len; j++){
//                     if(points[j][0] == x && points[j][1] == y)
//                         count ++;
//                 }
//             }
//             else{
//                 for(int j = 0; j < len; j ++){
//                     if((points[j][1] - y) * dx == (points[j][0] - x) * dy)
//                         count ++;
//                 }
//             }
//             res = Math.max(res, count);
//         }
//         return res;
//     }
// }

