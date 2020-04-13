/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,
 * 并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
package offer;
public class NumberOf1Between1AndN_Solution_31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        //遍历思想
        /*
        int res = 0;
        for (int i = n; i >= 1; i--) {
            for (int j = i; j > 0; j /= 10) {
                if (j % 10 == 1) {
                    res++;
                }
            }
        }
        return res;*/
        // 分别计算个位，十位，百位思想
        int cnt = 0;    
        for (int m = 1; m <= n; m *= 10) {        
            int a = n / m, b = n % m;
            if (a % 10 == 0) {
                cnt += (a / 10) * m;
            } else if (a % 10 > 1) {
                cnt += (a / 10 + 1) * m;
            } else {
                cnt += (a / 10) * m + b + 1;
            }
            //这么写特别好 一次判断
            //cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);    
        }    
        return cnt;
    }
}