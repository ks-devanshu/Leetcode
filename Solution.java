class Solution {
    public int minimumMountainRemovals(int[] nums) {
    	int n = nums.length;
        Map<Integer, Integer> lis = new HashMap<>();
        for (int i = 0; i<n; i++) {
        	int max = 1;
        	for (int j = 0; j<i; j++) {
        		if (nums[j] < nums[i])
        			max = Math.max(max, 1+lis.get(j));
        	}
        	lis.put(i, max);
        }
        
        Map<Integer, Integer> lds = new HashMap<>();
        for (int i = n-1; i>=0; i--) {
        	int max = 1;
        	for (int j = i+1; j<n; j++) {
        		if (nums[j] < nums[i])
        			max = Math.max(max, 1+lds.get(j));
        	}
        	lds.put(i, max);
        }
        
        int minRem = n;
        for (int i = 1;i<n-1; i++) {
        	if (lis.get(i) == 1 || lds.get(i) == 1)
        		continue;	
        	
        	minRem = Math.min(minRem, n-lis.get(i)-lds.get(i)+1);
        }
        return minRem;
    }
}