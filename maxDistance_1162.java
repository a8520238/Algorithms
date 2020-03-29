/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。

我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。

如果我们的地图上只有陆地或者海洋，请返回 -1

 */

import java.util.LinkedList;
import java.util.Queue;

//图的多源bfs
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        boolean haveSea = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int px = point[0] + dx[i];
                int py = point[1] + dy[i];
                if (px >= 0 && px < grid.length && py >= 0 && py < grid[0].length && grid[px][py] == 0) {
                    haveSea = true;
                    grid[px][py] = grid[point[0]][point[1]] + 1;
                    queue.add(new int[]{px, py});
                }
            }
        }
        if (!haveSea || point == null) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}