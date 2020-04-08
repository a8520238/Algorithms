/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3


示例 1：

输入：m = 3, n = 1, k = 0
输出：1


提示：


	1 <= n,m <= 100
	0 <= k <= 20
 */

 //bfs
class movingCount_face_13 {
    private int sum = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        bfs(0, 0, k, flag);
        return this.sum;
    }
    private void bfs(int i, int j, int k, boolean[][] flag) {
        if (i == flag.length || j == flag[0].length) {
            return;
        }
        if (check(i) + check(j) <= k && !flag[i][j]) {
            this.sum++;
            flag[i][j] = true;
            bfs(i + 1, j, k, flag);
            bfs(i, j + 1, k, flag);
        }
    }
    private int check(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n = n / 10;
        }
        return sum;
    }
}