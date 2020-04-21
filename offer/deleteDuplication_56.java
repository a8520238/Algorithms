/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
package offer;
public class deleteDuplication_56 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode sav = pre;
        ListNode cur = pHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return sav.next;
    }
    public class ListNode {
        int val;
        ListNode next = null;
    
        ListNode(int val) {
            this.val = val;
        }
    }
}