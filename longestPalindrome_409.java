import java.util.HashMap;
import java.util.Map;

//遍历hashmap的两种高效方法
class longestPalindrome_409 {
    public int longestPalindrome(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        // Sum sum = new Sum();
        int sum = 0;
        //boolean alone = false;
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sum += entry.getValue() / 2 * 2;
            if (sum % 2 == 0 && entry.getValue() % 2 == 1) {
                sum++;
            }
            // if (entry.getValue() % 2 == 0) {
            //     sum += entry.getValue();
            // }
            // else {
            //     alone = true;
            //     sum += entry.getValue() - 1;
            // }
        }
        return sum;
        //return alone ? sum+1 : sum;
        // map.entrySet().stream().forEach((entry) -> {
        //     if (entry.getValue() % 2 == 0) {
        //         sum.add(entry.getValue());
        //     }
        //     else {
        //         sum.alone();
        //         sum.add(entry.getValue()-1);
        //     }
        // });
        //return sum.getAlone() ? sum.getCount()+1: sum.getCount();
    }
    // class Sum{
    //     private int count;
    //     private boolean alone;
    //     Sum() {
    //         this.count = 0;
    //         this.alone = false;
    //     }
    //     public void add(int a) {
    //         count += a;
    //     }
    //     public void alone() {
    //         this.alone = true;
    //     }
    //     public int getCount() {
    //         return count;
    //     }
    //     public boolean getAlone() {
    //         return alone;
    //     }
    // }
}