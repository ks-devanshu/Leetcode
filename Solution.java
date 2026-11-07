class Solution {
    Set<String> set;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
    	this.s = s;
    	int n = s.length();
    	set = new HashSet<>();
    	for (var word : wordDict)
    		set.add(word);
    	
    	if (set.contains(s))
    		return true;
    	
    	for (int i = 1; i<=n; i++) {
    		if (set.contains(s.substring(0, i)) && helper(i, n))
    			return true;
    	}
    	return false;
    	
    }
    Map<String, Boolean> map = new HashMap<>();
    private boolean helper(int i, int j) {
    	if (j <= i)
    		return true;
        if (set.contains(s.substring(i, j)))
            return true;
        String key = i+" "+j;
        if (map.containsKey(key))
            return map.get(key);
        
        for (int k = i+1; k<j; k++) {
            map.put(key, helper(k, j));
    		if (set.contains(s.substring(i, k)) && map.get(key))
    			return true;
    	}
        map.put(key, false);
	    return map.get(key);
    }
}