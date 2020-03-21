/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例 1: (From the famous "Die Hard" example)
输入: x = 3, y = 5, z = 4
输出: True
示例 2:
输入: x = 2, y = 6, z = 5
输出: False
 */

class canMeasureWater_365 {
    //贝祖定理最大公约数法
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y==0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }
    private int gcd(int x, int y) {
        return y == 0? x: gcd(y, x % y);
    }

    //DFS思想
    // public boolean canMeasureWater(int x, int y, int z) {
    //     Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
    //     Set<Pair<Integer, Integer>> set = new HashSet<>();
    //     stack.addLast(new Pair(0, 0));
    //     while (!stack.isEmpty()) {
    //         Pair<Integer, Integer> pair = stack.pollLast();
    //         int m = pair.getKey();
    //         int n = pair.getValue();
    //         if (m == z || n == z || m + n == z) {
    //             return true;
    //         }
    //         if (set.contains(pair)) {
    //             continue;
    //         }
    //         set.add(pair);
    //         stack.addLast(new Pair(0, n));
    //         stack.addLast(new Pair(m, 0));
    //         stack.addLast(new Pair(x, n));
    //         stack.addLast(new Pair(m, y));
    //         stack.addLast(new Pair(m - Math.min(m, y-n), n + Math.min(m, y-n)));
    //         stack.addLast(new Pair(m + Math.min(n, x-m), n - Math.min(n, x-m)));
    //     }
    //     return false;
    // }

    //暴力穷举法
    // public boolean canMeasureWater(int x, int y, int z) {
    //     int maxV = Math.max(x, y);
    //     int minV = Math.min(x, y);
    //     int saveMax = maxV;
    //     int saveMin = minV;
    //     Set<Integer> set = new HashSet<>();
    //     set.add(0);
    //     set.add(maxV);
    //     set.add(minV);
    //     set.add(maxV + minV);
    //     while (minV > 0) {
    //         maxV = saveMax;
    //         if (minV != saveMin) {
    //             maxV = maxV - minV;
    //             set.add(maxV);
    //             minV = saveMin;
    //             set.add(maxV + minV);
    //         }
    //         while (maxV > minV) {
    //             maxV = maxV - minV;
    //             set.add(maxV);
    //             set.add(maxV + minV);
    //         }
    //         minV -= maxV;
    //     }
    //     if (set.contains(z)) {
    //         return true;
    //     }
    //     return false;
    // }
}