class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int pivot = n-1;
        while (pivot > 0 && nums[pivot] <= nums[pivot-1]) pivot--;
        if (pivot == 0) {
        	for (int i = 0; i<(n/2); i++) {
        		int temp = nums[i];
        		nums[i] = nums[n-i-1];
        		nums[n-i-1] = temp;
        	}
        	return;
        }
    	pivot--;
    	int swap = n-1;
    	while (swap > pivot && nums[swap] <= nums[pivot]) swap--;
    	
    	for (int i = pivot+1; i<n; i++) {
    		if (nums[i] > nums[pivot] && nums[i] - nums[pivot] < nums[swap] - nums[pivot])
    			swap = i;
    	}
    	
    	int help = nums[swap];
    	nums[swap] = nums[pivot];
    	nums[pivot] = help;
    	pivot++;
    	int mid = pivot + (n-pivot)/2;
    	int m = 1;
    	for (int i = pivot; i<mid; i++) {
    		int temp = nums[n-m];
    		nums[n-m] = nums[i];
    		nums[i] = temp;
    		m++;
    	}
    }
}