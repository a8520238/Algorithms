/**一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。 */
package offer;

//数学 fn = 2*(f(n-1))
public class JumpFloorII_9 {
    public int JumpFloorII(int target) {
        int res = 1;
        while (target > 1) {
            res = res * 2;
            target--;
        }
        return res;
    }
}