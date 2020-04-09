/**输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。 */
package offer;
public class VerifySquenceOfBST_23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length-1);
    }
    public boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int index = start;
        for ( ; index < end && sequence[index] < root; index++);
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return isBST(sequence, start, index - 1) && 
                isBST(sequence, index, end - 1);
    }
}