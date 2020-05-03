package offer;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuffer;
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
public class Serialize_61 {
    
    //先序思想更简单
    String Serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        if (root == null) {
            return "#";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                buffer.append("#");
                buffer.append(",");
            } else {
                buffer.append(cur.val);
                buffer.append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
  }
    TreeNode Deserialize(String str) {
        if (str == null || str.equals("#")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] s = str.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(s[0]));
        queue.add(head);
        int index = 1;
        
        while (index < s.length && !queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!s[index].equals("#")) {
                TreeNode newLeft = new TreeNode(Integer.parseInt(s[index]));
                cur.left = newLeft;
                index++;
                queue.add(newLeft);
            } else {
                index++;
            }
            if (!s[index].equals("#")) {
                TreeNode newRight = new TreeNode(Integer.parseInt(s[index]));
                cur.right = newRight;
                index++;
                queue.add(newRight);
            } else {
                index++;
            }
            
        }
        return head;
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