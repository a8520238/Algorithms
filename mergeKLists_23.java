import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
class mergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //最小堆解法 优先队列
        if (lists.length == 0 || lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (node1, node2) -> node1.val - node2.val);
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
       return head.next;
    }
    // public ListNode mergeKLists(ListNode[] lists) {
    //     //分治 递归版本 时间复杂度logK*N
    //     return help(lists, 0, lists.length-1);
    // }
    // private ListNode help(ListNode[] lists, int start, int end) {
    //     if (start > end) {
    //         return null;
    //     }
    //     if (start == end) {
    //         return lists[start];
    //     }
    //     int mid = (end - start) / 2 + start;
    //     ListNode l1 = help(lists, start, mid);
    //     ListNode l2 = help(lists, mid+1, end);
    //     return merge(l1, l2);
    // }
    // private ListNode merge(ListNode l1, ListNode l2) {
    //     ListNode head = new ListNode(-1);
    //     ListNode p = head;
    //     while (l1 != null && l2 != null) {
    //         if (l1.val > l2.val) {
    //             p.next = l2;
    //             p = p.next;
    //             l2 = l2.next;
    //         }
    //         else {
    //             p.next = l1;
    //             p = p.next;
    //             l1 = l1.next;
    //         }
    //     }
    //     if (l1 != null) {
    //         p.next = l1;
    //     }
    //     if (l2 != null) {
    //         p.next = l2;
    //     }
    //     return head.next;
    // }
}