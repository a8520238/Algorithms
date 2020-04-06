/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package offer;
public class reConstructBinaryTree_4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        return process(pre, 0, in, 0, in.length - 1);
    }
    public TreeNode process(int[] pre, int pStart,
                            int[] in, int iStart, int iEnd) {
        if (iStart > iEnd) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pStart]);
        if (iStart == iEnd) {
            return head;
        }
        int index;
        for (index = iStart; index <= iEnd; index++) {
            if (in[index] == pre[pStart]) {
                break;
            }
        }
        int lenL = index - iStart;
        head.left = process(pre, pStart + 1,in, iStart, index - 1);
        head.right = process(pre, pStart + lenL + 1, in, index + 1, iEnd);
        return head;
    }
}
class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }