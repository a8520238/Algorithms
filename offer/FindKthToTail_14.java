/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/


/**
输入一个链表，输出该链表中倒数第k个结点。 */
//快慢指针
package offer;
public class FindKthToTail_14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        //if (head == null || k == 0) {
        //    return null;
        //}
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}