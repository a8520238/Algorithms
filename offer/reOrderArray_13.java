/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
// 借助On额外空间，两次遍历
package offer;
import java.util.Arrays;
public class reOrderArray_13 {
    public void reOrderArray(int [] array) {
        int[] temp = Arrays.copyOf(array, array.length);
        int i = 0;
        for (int num: temp) {
            if (num % 2 == 1) {
                array[i++] = num;
            }
        }
        for (int num: temp) {
            if (num % 2 == 0) {
                array[i++] = num;
            }
        }
    }
}