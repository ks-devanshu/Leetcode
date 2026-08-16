import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int orangesRotting(int[][] grid) {
        // 0 - empty, 1 - fresh, 2 rotten
        int m = grid.length;
        int n = grid[0].length;
        int time = 0, fresh = 0;

        Queue<String> queue = new ArrayDeque<>();

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2)
                    queue.add(i+" "+j);
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty() && fresh > 0) {
            int k = queue.size();

            for (int i = 0; i<k; i++) {
                String[] index = queue.remove().split(" ");

                int row = Integer.parseInt(index[0]), col = Integer.parseInt(index[1]);

                for (var diff : directions) {
                    int nextRow = row + diff[0];
                    int nextCol = col + diff[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;

                    if (grid[nextRow][nextCol] != 1) continue;

                    queue.add(nextRow+" "+nextCol);
                    grid[nextRow][nextCol] = 2;
                    fresh--;
                }
            }

            time++;
        }

        return fresh > 0 ? -1 : time;
    }
}