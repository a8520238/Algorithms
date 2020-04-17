/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
package offer;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class FindNumbersWithSum_42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        Set<Integer> set = new HashSet<>();
        boolean first = true;
        int start = 0;
        while (start < array.length) {
            if (set.contains(sum - array[start])) {
                if (first) {
                    res.add(sum - array[start]);
                    res.add(array[start]);
                    first = false;
                } else if (res.get(0) * res.get(1) > array[start] * (sum - array[start])){
                    res.set(0, sum - array[start]);
                    res.set(1, array[start]);
                }
            } else {
                set.add(array[start]);
            }
            start++;
        }
        return res;
    }
}
//虽然用set能AC，但是这种双指针的做法更好
/*
import java.util.ArrayList;
public class Solution {    
public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    ArrayList<Integer> result=new ArrayList<Integer>();        
    //边界条件        
    if(array==null||array.length<=1){
        return result;        
    }        
    int smallIndex=0;        
    int bigIndex=array.length-1;        
    while(smallIndex<bigIndex){
    //如果相等就放进去             
    if((array[smallIndex]+array[bigIndex])==sum){
        result.add(array[smallIndex]);                
        result.add(array[bigIndex]);                 
        //最外层的乘积最小，别被题目误导
        break;        
    }else if((array[smallIndex]+array[bigIndex])<sum){
        smallIndex++;             
    }else{                 
        bigIndex--;             
        }        
    }        
    return result;}}
**/