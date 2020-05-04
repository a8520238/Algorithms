package offer;
public class movingCount_66 {
    private int[][] d = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] f = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, f) + 1;
    }
    
    public int dfs(int aim, int rows, int cols, int i, int j, boolean[][] f) {
        f[i][j] = true;
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int newI = i + d[k][0];
            int newJ = j + d[k][1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && !f[newI][newJ]
               && process(newI) + process(newJ) <= aim) {
                res += dfs(aim, rows, cols, newI, newJ, f) + 1;
            }
        }
        return res;
    }
    
    public int process(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}