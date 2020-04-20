/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
package offer;
public class multiply_51 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        if (A.length == 1) {
            return new int[] {1};
        }
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int[] res = new int[A.length];
        left[0] = A[0];
        right[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i-1] * A[i];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * A[i];
        }
        res[0] = right[1];
        res[A.length - 1] = left[A.length - 2];
        for (int i = 1; i < A.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
}