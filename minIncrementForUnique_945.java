/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
返回使 A 中的每个值都是唯一的最少操作次数。
示例 1:
输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2:
输入：[3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 */

import java.util.Arrays;

class minIncrementForUnique_945 {

    //排序+优化方法
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int sum = 0, take = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                take++;
                sum -= A[i];
            }
            else if (A[i] - A[i-1] > 1) {
                int give = Math.min(take, A[i] - A[i-1] -1);
                take -= give;
                sum += A[i-1]*give + (give+1)*give/2;
            }
        }
        if (A.length > 0) {
            sum += A[A.length-1]*take + (take+1)*take/2;
        }
        return sum;
    }

    //自己想的暴力方法，效率低下
    // public int minIncrementForUnique(int[] A) {
    //     if (A == null || A.length == 0) {
    //         return 0;
    //     }
    //     int Max = Arrays.stream(A).max().getAsInt();
    //     int[] arr = new int[80000];
    //     for (int num: A) {
    //         arr[num] += 1;
    //     }
    //     System.out.println(Arrays.toString(arr));
    //     int count = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] == 0) {
    //             continue;
    //         }
    //         while (arr[i] > 1) {
    //             int j = i + 1;
    //             count++;
    //             while (arr[j] != 0) {
    //                 j++;
    //                 count++;
    //             }
    //             arr[j] += 1;
    //             arr[i] -= 1;       
    //         }
    //     }
    //     return count;
    // }
}