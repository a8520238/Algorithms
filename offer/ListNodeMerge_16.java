/**入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。 */
package offer;
import java.util.PriorityQueue;
//这道题有两种想法 第一种归并思想， 第二种优先队列思想
public class ListNodeMerge_16 {
    //优先队列思想 这么写效率很低
    public ListNode Merge(ListNode list1,ListNode list2) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        ListNode head = new ListNode(1);;
        ListNode cur = head;
        while (list1 != null) {
            queue.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            queue.add(list2);
            list2 = list2.next;
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        return head.next;
    }
    //归并思想
    /*
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        else if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }*/
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}