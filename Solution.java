class Solution {
	int[][] grid;
	int m, n;
	int color = 2;
	Map<Integer, Integer> map = new HashMap<>();
	
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i<m; i++) {
        	for (int j = 0; j<n; j++)
        		if (grid[i][j] == 1) {
        			code(i, j);
        			color++;
        		}
        }        
        for (int i = 0; i<m; i++) {
        	for (int j = 0; j<n; j++) {
        		if (grid[i][j] == 0) {
        			int sum = 1;
        			Set<Integer> cSet = new HashSet<>();
        			if (i > 0 && grid[i-1][j] != 0)
        				cSet.add(grid[i-1][j]);
        			if (i+1 < m && grid[i+1][j] != 0)
        				cSet.add(grid[i+1][j]);
        			if (j > 0 && grid[i][j-1] != 0)
        				cSet.add(grid[i][j-1]);
        			if (j+1 < n && grid[i][j+1] != 0)
        				cSet.add(grid[i][j+1]);
        			for (var each : cSet)
        				sum += map.get(each);
        			maxArea = Math.max(maxArea, sum);
        		}
        	}
        }
        
        return maxArea == 0 ? m*n : maxArea;
        
    }
    
    private void code(int i, int j) {
    	if (i < 0 || i >= m || j < 0 || j >= n)
    		return;
    	
    	if (grid[i][j] == 0 || grid[i][j] == color)
    		return;
    	
    	grid[i][j] = color;
    	map.put(color, map.getOrDefault(color, 0)+1);
    	code(i, j+1);
    	code(i, j-1);
    	code(i+1, j);
    	code(i-1, j);
    }
}