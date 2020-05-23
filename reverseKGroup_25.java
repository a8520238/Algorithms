import java.util.LinkedList;
import java.util.Queue;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 

说明：


	你的算法只能使用常数的额外空间。
	你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class reverseKGroup_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Queue<ListNode> queue = new LinkedList<>();
        ListNode mid = head.next;
        int len = 0;
        ListNode s = head;
        while (head != null) {
            head = head.next;
            len++;
        }
        head = s;
        while (head != null) {
            if (len < k) {
                queue.add(head);
                break;
            }
            int n = k;
            ListNode pre = null;
            ListNode cur = null;
            while (n > 0) {
                cur = mid;
                mid = mid == null? null: mid.next;
                head.next = n == k? null: pre;
                pre = head;
                head = cur;
                n--;
            }
            len -= k;
            queue.add(pre);
        }
        
        head = queue.poll();
        ListNode save = head;
        while (head.next != null || !queue.isEmpty()) {
            if (head.next != null) {
                head = head.next;
            } else {
                head.next = queue.poll();
                head = head.next;
            }
        }
        return save;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = reverseKGroup(node1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

//分段反转
/**
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode end = dummy;

    while (end.next != null) {
        for (int i = 0; i < k && end != null; i++) end = end.next;
        if (end == null) break;
        ListNode start = pre.next;
        ListNode next = end.next;
        end.next = null;
        pre.next = reverse(start);
        start.next = next;
        pre = start;

        end = pre;
    }
    return dummy.next;
}

private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
    return pre;
}
*/