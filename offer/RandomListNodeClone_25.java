/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
package offer;
//此题有两种解法，一种通过hash表， 一种通过倍增法， 现在写一下第二种
public class RandomListNodeClone_25 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }
        node = pHead;
        while (node != null) {
            if (node.random == null) {
                node.next.random = null;
            }
            else {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = pHead;
        RandomListNode res = node.next;
        while (node != null && node.next != null) {
            RandomListNode temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return res;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
    
        RandomListNode(int label) {
            this.label = label;
        }
    }
}