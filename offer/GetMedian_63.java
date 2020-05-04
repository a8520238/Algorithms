
package offer;
import java.util.PriorityQueue;
public class GetMedian_63 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
    int count = 0;
    
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 1) {
            return (double)(minHeap.peek());
        } else {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        }
    }


}