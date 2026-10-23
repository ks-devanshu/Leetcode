class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        if (n == 1)
        	return 0;
        
        int b = 0, moves = 0;
        for (char alpha : s.toCharArray()) {
        	if (alpha == 'a') {
        		moves = Math.min(b, moves+1);
        	}
        	else {
        		b++;
        	}
        }
        
        
        return moves;
    }
}