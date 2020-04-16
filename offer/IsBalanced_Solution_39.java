/**输入一棵二叉树，判断该二叉树是否是平衡二叉树。 */
package offer;
public class IsBalanced_Solution_39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = findH(root.left);
        int rightH = findH(root.right);
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(leftH - rightH) <= 1;
    }
    
    public int findH(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findH(root.left)+1, findH(root.right)+1);
    }
}