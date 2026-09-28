class Solution {
    String s,t;
    int m, n;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        m = s.length();
        n = t.length();
        return helper(0, 0);
    }
    Map<String, Integer> map = new HashMap<>();
    private int helper(int i, int j) {
    	if (j >= n)
    		return 1;
    	if (i >= m)
    		return 0;
    	String key = i+" "+j;
    	if (map.containsKey(key))
    		return map.get(key);
    	
    	if (s.charAt(i) == t.charAt(j)) {
    		map.put(key, helper(i+1, j+1)+helper(i+1, j));
    	}
    	else
    		map.put(key, helper(i+1, j));
    	
    	return map.get(key);
    }
}