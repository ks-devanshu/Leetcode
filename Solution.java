class Solution {
	String s1, s2, s3;
	int m, n, o;
	Map<String, Boolean> map = new HashMap<>();
	private boolean helper(int i, int j, int k) {
		if (k == o) {
			if (i == n && j == m)
				return true;
			return false;
		}
		String key = i+" "+j+" "+k;
		if (map.containsKey(key))
			return map.get(key);
		
		if (i < n && s3.charAt(k) == s1.charAt(i)) {
			if (j < m && s3.charAt(k) == s2.charAt(j))
				map.put(key, helper(i, j+1, k+1) || helper(i+1, j, k+1));
			else
				map.put(key,helper(i+1, j, k+1));
		}
		else if (j < m && s3.charAt(k) == s2.charAt(j))
			map.put(key, helper(i, j+1, k+1));
		else
			map.put(key, false);
		
		return map.get(key);
	}
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        n = s1.length();
        m = s2.length();
        o = s3.length();
        
        return helper(0,0,0);
    }
}