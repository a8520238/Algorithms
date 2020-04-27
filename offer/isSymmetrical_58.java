/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
package offer;
public class isSymmetrical_58 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return process(pRoot.left, pRoot.right);
    }
    boolean process(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null) {
            return true;
        }
        if (pLeft == null || pRight == null) {
            return false;
        }
        if (pLeft.val != pRight.val) {
            return false;
        }
        return process(pLeft.left, pRight.right) && process(pLeft.right, pRight.left);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
    
    }
}