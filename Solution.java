class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] a = str1.toCharArray(), b = str2.toCharArray();
        int m = a.length, n = b.length;
        
        System.out.println(n);
        
    	String[] dp = new String[n+1];
    	dp[0] = "";
    	for (int i = 1; i<=n; i++) {
    		dp[i] = dp[i-1]+b[i-1];
    	}
    	
    	for (int i = 0; i<m; i++) {
    		String[] temp = new String[n+1];
    		temp[0] = dp[0]+a[i];
    		for (int j = 1; j<=n; j++) {
    			if (a[i] == b[j-1]) {
    				temp[j] = dp[j-1]+a[i];
    			}
    			else {
    				if (dp[j].length() <= temp[j-1].length()) {
    					temp[j] = dp[j]+a[i];
    				}
    				else
    					temp[j] = temp[j-1]+b[j-1];
    			}
    		}
    		dp = temp;
    	}
        
        return dp[n];
    }
}