/**操作给定的二叉树，将其变换为源二叉树的镜像。 */

//递归
package offer;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Mirror_18 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        change(root);
        Mirror(root.left);
        Mirror(root.right);
    }
    private void change(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}