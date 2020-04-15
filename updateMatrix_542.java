
/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1: 
输入:

0 0 0
0 1 0
0 0 0


输出:

0 0 0
0 1 0
0 0 0


示例 2: 
输入:

0 0 0
0 1 0
1 1 1


输出:

0 0 0
0 1 0
1 2 1

 */
import java.util.LinkedList;
import java.util.Queue;

//多源bfs
class updateMatrix_542 {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] save = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int[][] res = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                if (matrix[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int i1 = i + save[k][0];
                        int j1 = j + save[k][1];
                        if (i1 >= 0 && i1 < row && j1 >= 0 && j1 < col && matrix[i1][j1] == 0) {
                            res[i][j] = 1;
                            queue.add(new int[] {i, j});
                            break;
                        }
                    }
                    if (res[i][j] == 0) {
                        res[i][j] = -1;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i1 = point[0] + save[k][0];
                int j1 = point[1] + save[k][1];
                if (i1 >= 0 && i1 < row && j1 >= 0 && j1 < col && res[i1][j1] == -1) {
                    res[i1][j1] = res[point[0]][point[1]] + 1;
                    queue.add(new int[] {i1, j1});
                }
            }
        }
        return res;
    }
}