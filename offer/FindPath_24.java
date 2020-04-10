/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
package offer;
import java.util.ArrayList;
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
//回溯思想
public class FindPath_24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (target == 0 || root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        dfs(root, target, sum, res, list);
        return res;
    }
    public void dfs(TreeNode root, int target, int sum,
                    ArrayList<ArrayList<Integer>> res, 
                    ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum += root.val;
        if (sum > target) {
            return;
        }
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer> (list));
        }
        dfs(root.left, target, sum, res, list);
        dfs(root.right, target, sum, res, list);
        list.remove(list.size() - 1);  
        sum -= root.val;
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