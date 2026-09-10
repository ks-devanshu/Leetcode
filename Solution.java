class Solution {
	int[] nums;
	int n;
	List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;

        helper(0, new ArrayList<>());
        
        return subsets;
    }
    
    private void helper(int i, List<Integer> current) {
    	if (i >= n) {
    		subsets.add(new ArrayList<>(current));
    		return;
    	}
    	
    	current.add(nums[i]);
    	helper(i+1, current);
    	
    	int end = current.remove(current.size()-1);
    	while (i+1 < n && nums[i] == nums[i+1]) i++;
    	helper(i+1, current);
    }
}