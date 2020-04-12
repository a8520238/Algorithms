/**
 * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。

给你网格图的行数 n 。

请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。

 * 
 */
//一种dp思想的数学方法
class numOfWays_5383 {
    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;
        //long m = (long)10e8 + 7;
        long m = 1000000007;
        while (n - 1 > 0) {
            n--;
            long aba1 = (aba * 3 % m + abc * 2 % m) % m;
            long abc1 = (aba * 2 % m + abc * 2 % m) % m;
            aba = aba1;
            abc = abc1;
        }
        return (int)((aba + abc) % m);
    }
}