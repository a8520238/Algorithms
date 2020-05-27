import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：A = [4,5,0,-2,-3,1], K = 5 输出：7 解释： 有 7 个子数组满足其元素之和可被 K = 5 整除： [4, 5, 0,
 * -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 30000 -10000 <= A[i] <= 10000 2 <= K <= 10000
 */
// 前缀和 同余法
class subarraysDivByK_974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int n : A) {
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            sum += n;
            int key = (sum % K + K) % K;
            int cur = map.getOrDefault(key, 0);
            res += cur;
            map.put(key, cur+1);
        }
        return res;
    }
}

//On2超时
// class Solution {
//     int res = 0;
//     public int subarraysDivByK(int[] A, int K) {
//         for (int i = 0; i < A.length; i++) {
//             process(A, i, K);
//         }
//         return res;
//     }

//     public void process(int[] A, int index, int K) {
//         int sum = 0;
//         for (int pos = index; pos < A.length; pos++) {
//             sum += A[pos];
//             if (sum % K == 0) {
//                 res++;
//             } 
//         }
//     }
// }