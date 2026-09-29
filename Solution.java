class Solution {
    public int minDistance(String f, String s) {
        int m = f.length(), n = s.length();
        if (n == 0)
        	return m;
        if (m == 0)
        	return n;
        
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++)
        	dp[i] = i;
        
        for (int i = 0; i<m; i++) {
        	int[] temp = new int[n+1];
        	temp[0] = i+1;
        	for (int j = 1; j<=n; j++) {
        		if (f.charAt(i) == s.charAt(j-1)) {
        			temp[j] = dp[j-1];
        		}
        		else {
        			int op = Math.min(temp[j-1], Math.min(dp[j], dp[j-1]));
        			op += 1;
        			temp[j] = op;
        		}
        	}
        	dp = temp;
        }
        
        return dp[n];
    }
}