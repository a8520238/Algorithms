
package offer;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class maxInWindows_64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = num.length;
        if (len * size == 0) {
            return list;
        } 
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - size >= deque.peekFirst()) {
                deque.pollFirst();
            }
            if (i >= size - 1) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }
}