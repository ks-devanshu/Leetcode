class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int length = 1;
        String result = s.charAt(0)+"";
        
        for (int i = 0; i<n; i++) {
        	// odd
        	int left = i, right = i;
        	while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        		int len = right-left+1;
        		if (len > length) {
        			length = len;
        			result = s.substring(left, right+1);
        		}
        		left--;
        		right++;
        	}
        	
        	// even
        	left = i;
        	right = i+1;
        	while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        		int len = right-left+1;
        		if (len > length) {
        			length = len;
        			result = s.substring(left, right+1);
        		}
        		left--;
        		right++;
        	}
        }
        
        return result;
    }
}