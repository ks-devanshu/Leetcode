class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int[] dp = new int[n+1];
        for(int i = 0; i<n+1; i++)
        	dp[i] = 1_000_000_000;
        
        for (int i = 0; i<n; i++) {
        	int index = bSearch(dp, arr[i]);
        	res[i] = index+1;
        	dp[index] = arr[i];
        }
        
        return res;
    }
    private int bSearch(int[] dp, int num) {
    	int left = 0, right = dp.length-1;
    	while (left < right) {
    		int mid = left + (right-left)/2;
    		if (num < dp[mid])
    			right = mid;
    		else
    			left = mid+1;
    	}
    	return right;
    }
}