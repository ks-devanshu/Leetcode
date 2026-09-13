class Solution {
    class Pair {
    	int i, j, value;
    	
    	public Pair(int i, int j, int value) {
    		this.i = i;
    		this.j = j;
    		this.value = value;
    	}
    }
    
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 
        
        Map<String, Integer> map = new HashMap<>();
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(x->x.value));
        
        queue.add(new Pair(0, 0, grid[0][0]));
        
        while(!queue.isEmpty()) {
        	Pair current = queue.poll();
        	int row = current.i, col = current.j, value = current.value;
        	map.put(row+" "+col, value);
            if (row == m-1 && col == n-1) break;
        	
        	if (col-1 >= 0 && !map.containsKey(row+" "+(col-1)))
        		queue.add(new Pair(row, col-1, Math.max(value, grid[row][col-1])));
        	if (col+1 < n && !map.containsKey(row+" "+(col+1)))
        		queue.add(new Pair(row, col+1, Math.max(value, grid[row][col+1])));
			if (row-1 >= 0 && !map.containsKey((row-1)+" "+col))
        		queue.add(new Pair(row-1, col, Math.max(value, grid[row-1][col])));
			if (row+1 < m && !map.containsKey((row+1)+" "+col))
        		queue.add(new Pair(row+1, col, Math.max(value, grid[row+1][col])));
        }
        
        return map.get((m-1)+" "+(n-1));
    }    
}