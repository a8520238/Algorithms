package offer;
public class cutRope_67 {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int res = 1;
        while (target > 4) {
            target -= 3;
            res *= 3;
        }
        res *= target;
        return res;
    }
}