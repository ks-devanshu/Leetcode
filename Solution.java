class Solution {
	int[] nums;
	int n;
	
	List<List<Integer>> result = new ArrayList<>();
	Map<Integer, Integer> map = new HashMap<>();
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        for (var num : nums) {
        	if(map.containsKey(num))
        		map.replace(num, map.get(num)+1);
        	else
        		map.put(num, 1);
        }

        helper(new ArrayList<>());
        
        return result;
    }
    
    private void helper(List<Integer> list) {
    	if (list.size() >= n) {
    		result.add(new ArrayList<>(list));
    		return;
    	}
    	
    	for (var next : map.keySet()) {
    		if (map.get(next) > 0) {
    			list.add(next);
    			map.replace(next, map.get(next)-1);
    			helper(list);
    			
    			list.remove(list.size()-1);
    			map.replace(next, map.get(next)+1);
    		}
    	}
    }
}