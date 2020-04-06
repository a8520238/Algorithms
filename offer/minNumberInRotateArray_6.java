
package offer;
//import java.util.ArrayList;
public class minNumberInRotateArray_6 {
    public int minNumberInRotateArray(int [] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] < array[end]) {
                return array[start];
            }
            int mid = (end - start) / 2 + start;
            if (array[start] < array[mid]) {
                start = mid + 1;
            }
            else if (array[mid] < array[end]) {
                end = mid;
            }
            else {
                start++;
            }
        }
        return array[start];
        /*
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                return array[i+1];
            }
        }
        return array[0];*/
    }
}