package offer;
import java.util.Arrays;
public class isContinuous_45 {
    //使用遍历法过了AC，最优解在下面
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int king = 0;
        while (numbers[king] == 0) {
            king++;
        }
        for (int i = king; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i+1]) {
                if (king > 0) {
                    king--;
                    numbers[i] += 1;
                    i--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
//通过treeset和判断边界才是正解
/*
import java.util.TreeSet;
public class Solution {    
    public boolean isContinuous(int [] n) {        
        if (n.length < 5 || n.length > 5) {            
            return false;        
        }        
        int num = 0;        
        TreeSet<Integer> set = new TreeSet<> ();        
        for (int i=0; i<n.length;i++) {            
            if (n[i]==0) {                
                num ++;            
            } else {                
                set.add(n[i]);            
            }        
        }        
        if ((num + set.size()) != 5) {            
            return false;        
        }        
        if ((set.last() - set.first()) < 5) {            
            return true;        
        }        
        return false;    
    }
}*/