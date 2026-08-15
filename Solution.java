import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int pathLength = 0;
        
        Queue<Integer> rowQ = new ArrayDeque<>();
        Queue<Integer> colQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        rowQ.add(0);
        colQ.add(0);        
        
        while (!rowQ.isEmpty()) {
            int k = rowQ.size();
            
            for (int i = 0; i<k; i++) {
                int row = rowQ.remove();
                int col = colQ.remove();
                
                if (row < 0 || row >= n || col < 0 || col >= n) continue;
                
                if (visited.contains(row+""+col) || grid[row][col] == 1) continue;
                
                if (row == n-1 && col == n-1) return 1+ pathLength;
                
                rowQ.add(row);
                colQ.add(col+1);
                
                rowQ.add(row);
                colQ.add(col-1);
                
                rowQ.add(row+1);
                colQ.add(col);
                
                rowQ.add(row-1);
                colQ.add(col);
                
                rowQ.add(row+1);
                colQ.add(col+1);
                
                rowQ.add(row-1);
                colQ.add(col+1);
                
                rowQ.add(row-1);
                colQ.add(col-1);
                
                rowQ.add(row+1);
                colQ.add(col-1);
                
                visited.add(row+""+col);
            }
            
            pathLength++;
        }
        
        return -1;
    }
}