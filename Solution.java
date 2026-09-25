class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int tSum = 0;
        for (var num : nums)
        	tSum += num;
        
        if (tSum % 2 != 0) return false;
        
        int target = tSum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[n-1]);
        for (int i = n-2; i>=0; i--) {
        	var list = new ArrayList<Integer>();
        	for (var each : set)
        		list.add(each+nums[i]);
        	set.addAll(list);
        	if (set.contains(target))
        		return true;
        }
        
        return false;
    }
}