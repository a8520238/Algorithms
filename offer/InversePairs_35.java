/** 
 *  算法知识视频讲解 
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
*/
package offer;
public class InversePairs_35 {
    private int res = 0;
    private int t = 1000000007;
    public int InversePairs(int [] array) {
        mergeCheck(array, 0, array.length - 1);
        return res;
    }
    public void mergeCheck(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeCheck(arr, start, mid);
        mergeCheck(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, t = 0;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] > arr[p2]) {
                res += mid - p1 + 1;
                res %= this.t;
                temp[t++] = arr[p2++];
            } else {
                temp[t++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            temp[t++] = arr[p1++];
        }
        while (p2 <= end) {
            temp[t++] = arr[p2++];
        }
        for (int n: temp) {
            arr[start++] = n;
        }
    }
}