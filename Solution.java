class Solution {
	int[] nums;
	int n, target;
	
	Map<String, Integer> map = new HashMap<>();
	
	private int helper(int i, int sum) {
		String help = i+" "+sum;
		if (i >= n) {
			if (sum == target)
				return 1;
			return 0;
		}
		
		if (map.containsKey(help))
			return map.get(help);
		
		map.put(help, (helper(i+1, sum-nums[i]) + helper(i+1, sum+nums[i])));
		
		return map.get(help);
	}
	
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;
        this.target = target;

        return helper(0, 0);
    }
}