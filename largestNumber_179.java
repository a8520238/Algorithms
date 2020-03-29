/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210

示例 2:

输入: [3,30,34,5,9]
输出: 9534330

说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数

 */

import java.util.Arrays;

//比较器 stream lamba
//基于字符串的拼接模式
class Solution {
    public String largestNumber(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).
                compareTo(x + y)).forEach(x -> buffer.append(x));
        return buffer.charAt(0) == '0' ? "0" : buffer.toString();
    }
}

// 基于数值的算法会超范围
// class Solution {
//     public String largestNumber(int[] nums) {
//         Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//         Arrays.sort(integers, (x, y) -> (int)(y * Math.pow(10, count(x))) + x - (int) (x * Math.pow(10, count(y))) - y);
//         StringBuffer buffer = new StringBuffer();
//         for (int num: integers) {
//             buffer.append(String.valueOf(num));
//         }
//         return buffer.toString();
//     }

//     private int count(int num) {
//         int n = 0;
//         while (num != 0) {
//             num /= 10;
//             n++;
//         }
//         System.out.println(n);
//         return n;
//     }
// }