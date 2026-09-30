class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 0; i<n; i++) {
        	int[] temp = new int[n+1];
        	int left = n-i-1;
        	for (int j = 1; j<=n; j++) {
        		if (s.charAt(j-1) == s.charAt(left)) {
        			temp[j] = 1 + dp[j-1];
        		}
        		else {
        			temp[j] = Math.max(dp[j], temp[j-1]);
        		}
        	}
        	dp = temp;
        }
        
        return dp[n];
    }
}