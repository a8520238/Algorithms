package offer;
public class GetNumberOfK_37 {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k){
                right = mid;
            } else {
                left = mid;
                break;
            }
        }
        int save = left + 1;
        int res = 0;
        while (left >= 0) {
            if (array[left] == k) {
                left--;
                res++;
            } else {
                break;
            }
        }
        while (save < array.length) {
            if (array[save] == k) {
                save++;
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}