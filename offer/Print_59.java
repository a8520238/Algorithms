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
public class Print_59 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        int flag = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> curList = new ArrayList<>();
            Queue<TreeNode> curQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                cur = queue.poll();
                if (cur != null) {
                    curQueue.add(cur.left);
                    curQueue.add(cur.right);
                    if (flag % 2 == 1) {
                        curList.add(cur.val);
                    } else {
                        curList.add(0, cur.val);
                    }
                }
            }
            queue = curQueue;
            if (curList != null && curList.size() != 0) {
                res.add(curList);
            }
            flag++;
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