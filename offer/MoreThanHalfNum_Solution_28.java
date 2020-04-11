/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 */
package offer;
// import java.util.Map;
// import java.util.HashMap;
import java.util.stream.IntStream;

public class MoreThanHalfNum_Solution_28 {
    //第一种万能的hashmap 相似的思想也可以用排序，看中位数的个数是否大于一半
    /*
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                res = entry.getKey();
            }
        }
        return res;
    }*/
    //第二种思想 对命思想
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int pre = array[0];
        for (int n: array) {
            if (count == 0) {
                pre = n;
                count = 1;
            } else {
                if (n == pre) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        int c = pre;
        long res = IntStream.of(array).filter(x->x==c).count();
        return res > array.length / 2? c: 0;
    }
}