/**从上往下打印出二叉树的每个节点，同层节点从左至右打印。 */
package offer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//这是一道层次遍历的题
public class PrintFromTopToBottom_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            list.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        return list;
    }
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
    }
}