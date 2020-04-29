
package offer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
public class Print_60 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    list.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            if (list.size() != 0) {
                res.add(list);
            }
            
        }
        return res;
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