package offer;
/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindFirstCommonNode_36 {
    //这题按道理得判断是否成环  看AC情况应该是不考虑
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        
        //这种解法将两个链表相连，如相交必然相遇，如不想交必然交于null;
        /*
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;*/
        //这种思想是结环思想， 注意要执行cur1.next = null;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode cur1 = pHead1;
        while (cur1.next != null) {
            cur1 = cur1.next;
        }
        cur1.next = pHead1;
        ListNode fast = pHead2;
        ListNode slow = pHead2;
        do {
            if (fast.next == null || fast.next.next == null) {
                cur1.next = null;
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        
        fast = pHead2;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        cur1.next = null;
        return fast;
    }
}