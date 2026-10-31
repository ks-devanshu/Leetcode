class Solution {
    final int MOD = 1_000_000_007;
    private long biPow(long a, long b) {
    	long res = 1;
    	while (b > 0) {
    		if ((b & 1) == 1) {
    			res = res * a % MOD;
    		}
            a = a * a % MOD;
    		b >>= 1;
    	}
    	return res;
    }
    
    public int countGoodNumbers(long n) {
        if (n == 1)
        	return 5;
        
        long even = (n + 1) >> 1;
        long odd = n >> 1;
        
        long result = biPow(5, even) * biPow(4, odd) % MOD;

        return (int) result;
    }
}