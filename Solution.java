class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        
        int max = intervals[0][1], count = 0, i = 1;
        while (i < n) {
        	int[] current = intervals[i];
        	if (current[0] < max) {
        		max = Math.min(max, current[1]);
        		count++;
        	}
        	else {
        		max = current[1];
        	}
        	i++;
        }
        
        return count;
    }
}