
package offer;
public class hasPath_65 {
    private boolean[][] f;
    private int[][] change = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (str == null || str.length == 0) {
            return false;
        }
        char[][] m = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            m[i / cols][i % cols] = matrix[i];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == str[0]) {
                    f = new boolean[rows][cols];
                    if (dfs(i, j, m, str, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] m, char[] str, int index) {
        if (index == str.length) {
            return true;
        }
        for (int k = 0; k < 4; k++) {
            f[i][j] = true;
            int newI = i + change[k][0];
            int newJ = j + change[k][1];
            if (newI >= 0 && newI < m.length && newJ >= 0 && newJ < m[0].length && 
                m[newI][newJ] == str[index] && !f[newI][newJ]) {
                if (dfs(newI, newJ, m, str, index+1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[] m = new char[] {'A', 'B', 'C','E','S','F','C','S','A','D','E','E'};
        char[] str = new char[] {'A', 'B', 'C', 'C', 'E', 'D'};
        hasPath_65 test = new hasPath_65();
        System.out.println(test.hasPath(m, 3, 4, str));
    }
}