class Solution {
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length, count = 0;
        
        for (int i = 0; i<n; i++) {
        	int gcd = 0;
        	for (int j = i; j<n; j++) {
        		gcd = gcd(gcd, nums[j]);
        		if (gcd == k)
        			count++;
        	}
        }
        return count;
    }
}