/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
 */
class buildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return process(preorder, inorder, 0, preorder.length, 0);
    }
    public TreeNode process(int[] preorder, int[] inorder, int start, int end, 
                            int offset) {
        if (start >= end) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[offset]);
        int index = 0;
        for (int i = start; i < end; i++) {
            if (inorder[i] == preorder[offset]) {
                index = i;
            }
        }
        head.left = process(preorder, inorder, start, index, offset + 1);
        head.right = process(preorder, inorder, index+1, end, index - start + offset + 1);
        return head;
    }
    public class TreeNode {
        int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
}