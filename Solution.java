class Solution {
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(1, n, k, new ArrayList<>());
        return result;
    }
    
    public void helper(int i, int n, int k, List<Integer> current) {
    	if (current.size() == k) {
    		result.add(new ArrayList<>(current));
    		return;
    	}
    	if (i > n)
    		return;
    	
    	for (int j = i; j<=n; j++) {
    		current.add(j);
    		helper(j+1, n, k, current);
    		current.remove(current.size() - 1);
    	}
    }
}