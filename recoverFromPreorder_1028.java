/**我们从二叉树的根节点 root 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 S，还原树并返回其根节点 root。
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class recoverFromPreorder_1028 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                level++;
                pos++;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + S.charAt(pos) - '0';
                pos++;
            }

            TreeNode node = new TreeNode(value);

            if (level == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }

            } else {
                while (level != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
}