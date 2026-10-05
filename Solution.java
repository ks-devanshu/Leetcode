class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int num : nums)
        	max = Math.max(max, num);
        
        int lMax = 1, lMin = 1;
        for (int num : nums) {
        	if (num == 0) {
        		lMax = 1;
        		lMin = 1;
        		continue;
        	}
        	int temp = lMax*num;
        	lMax = Math.max(num, Math.max(lMax*num, lMin*num));
        	lMin = Math.min(num, Math.min(temp, lMin*num));
        	max = Math.max(max, lMax);
        }
        return max;
    }
}