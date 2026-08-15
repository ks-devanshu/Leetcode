class Solution {
    private int islandCount, m, n;
    private char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    islandCount++;
                }
        return islandCount;
    }
    
    private void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        
        if (grid[row][col] == '0' || grid[row][col] == '9') return;
        
        grid[row][col] = '9';
        
        dfs(row, col+1);
        dfs(row, col-1);
        dfs(row+1, col);
        dfs(row-1, col);
    }
}