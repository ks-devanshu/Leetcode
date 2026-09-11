class Solution {
	
	int[] nums;
	int n;
	
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        return helper(0);
        
    }
    
    private List<List<Integer>> helper(int i) {
    	if (i >= n) {
    		List<List<Integer>> list = new ArrayList<>();
    		list.add(new ArrayList<>());
    		return list;
    	}
    	
    	List<List<Integer>> result = new ArrayList<>();
    	var perms = helper(i+1);
    	for (var each : perms) {
    		for (int j = 0; j<each.size()+1; j++) {
    			var copy = new ArrayList<>(each);
    			copy.add(j, nums[i]);
    			result.add(copy);
    		}
    	}
        return result;
    }
}	