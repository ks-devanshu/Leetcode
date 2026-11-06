class Solution {
    public int superPow(int a, int[] b) {
        if (a == 1)
        	return 1;
        
        if (b.length == 1) {
        	if (b[0] == 0)
        		return 1;
        	if (b[0] == 1)
        		return a;
        }
        int mod = 1337, phi = 1140;
        int num = 0;
        boolean isLarge = false;
        for (var digit : b) {
        	num = num*10 + digit;
        	if (num >= phi) {
        		isLarge = true;
        		num %= phi;
        	}
        }
        
        if (isLarge)
        	num += phi;
        
        a %= mod;
        long res = 1;
        while (num > 0) {
        	if ((num&1) == 1)
        		res = res * a % mod;
        	a = a * a % mod;
        	num >>= 1;
        }
        return (int) res;
    }
}