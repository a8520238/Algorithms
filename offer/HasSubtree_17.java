/**输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构） */

package offer;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
// 递归解法
public class HasSubtree_17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return find(root1, root2) || find(root1.left, root2) || find(root1.right, root2);
    }
    public boolean find(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return find(root1.left, root2.left) && find(root1.right, root2.right); 
        }
        return find(root1.left, root2) || find(root1.right, root2);
    }
}