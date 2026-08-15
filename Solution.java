class Solution {
    private int[][] grid;
    private int maxArea = 0, m, n;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 0;
        
        if (grid[row][col] == 0 || grid[row][col] == 9) return 0;
        
        int area = 1;
        grid[row][col] = 9;
        
        area += dfs(row, col+1);
        area += dfs(row, col-1);
        area += dfs(row+1, col);
        area += dfs(row-1, col);
        
        return area;
    }
}