/**
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
public class Convert_26 {
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.right);
        if (pre == null) {
            pre = pRootOfTree;
        }
        else {
           pRootOfTree.right = pre;
           pre.left = pRootOfTree;
           pre = pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return pre;
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