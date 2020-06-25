/**序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #


例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。

给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。

每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。

你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 */

class isValidSerialization_331 {
    //匹配思想
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        int count = 0;
        String[] str = preorder.split(",");
        int i = str.length - 1;
        while (i > 0) {
            if (!str[i].equals("#")) {
                if (count > 1) {
                    count -= 1;
                    i--;
                } else {
                    return false;
                    
                }
            }
            if (str[i].equals("#")) {
                if (i-1 >= 0 && str[i-1].equals("#")) {
                    if (i-2 >= 0 && !str[i-2].equals("#")) {
                        i -= 3;
                        count++;
                    } else {
                        i -= 2;
                        count += 2;
                        
                    }
                } else {
                    if (count > 0) {
                        i -= 2;
                    } else {
                        return false;
                        
                    }
                }
            }
        }
        return i == -1 && count == 1 || i == 0 && count == 2 && !str[i].equals("#");
    }
}
//官方槽位思想
// class Solution {
//   public boolean isValidSerialization(String preorder) {
//     // number of available slots
//     int slots = 1;

//     for(String node : preorder.split(",")) {
//       // one node takes one slot
//       --slots;

//       // no more slots available
//       if (slots < 0) return false;

//       // non-empty node creates two children slots
//       if (!node.equals("#")) slots += 2;
//     }

//     // all slots should be used up
//     return slots == 0;
//   }
// }
