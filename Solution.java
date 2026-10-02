class Solution {
    public int[] sortedSquares(int[] nums) {
    	int n = nums.length;
        int[] result = new int[n];
        
        int left = 0, right = n-1;
        int i = n-1;
        while (left <= right) {
        	if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
        		result[i] = nums[left]*nums[left];
        		left++;
        	}
        	else {
        		result[i] = nums[right]*nums[right];
        		right--;
        	}
        	i--;
        }
        
        return result;
    }
}