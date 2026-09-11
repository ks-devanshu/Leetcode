class Solution {
	int k;
	String digits;
	List<String> result = new ArrayList<>();
	
	Map<Character, String> map = new HashMap<>();
	
    public List<String> letterCombinations(String digits) {
        k = digits.length();
        this.digits = digits;
        populateMap();
        
        helper(0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int i, List<String> current) {
    	if (i >= k) {
    		result.add(String.join("", current));
    		return;
    	}
    	
    	String mapping = map.get(digits.charAt(i));
    	
    	for (var alpha : mapping.toCharArray()) {
    		current.add(alpha+"");
    		helper(i+1, current);
    		current.remove(current.size() - 1);
    	}
    	
    }
    
    private void populateMap() {
    	map.put('2', "abc");
    	map.put('3', "def");
    	map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "nmo");
    	map.put('7', "pqrs");
    	map.put('8', "tuv");
    	map.put('9', "wxyz");    	    	    	    	    	    	    	
    }
}