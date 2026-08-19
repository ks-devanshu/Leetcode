import java.util.Map;
import java.util.HashMap;

class Solution {
    int m, n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        return helper(0, 0);
    }

    private Map<String, Integer> map = new HashMap<>();

    private int helper(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 0;

        if (row == m-1 && col == n-1) return 1;

        if (map.containsKey(row+" "+col)) return map.get(row+" "+col);

        map.put( row+" "+col , (helper(row, col+1) + helper(row+1, col)));

        return map.get(row+" "+col);
    }
}