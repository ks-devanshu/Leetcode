class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i<=n; i++)
            isPrime[i] = true;
        
        int count = 0;
        for (int i = 2; i<n; i++) {
            if (isPrime[i])
                count++;
            if ((long) i*i <= n) {
                for (int j = i*i; j<= n; j += i) {
                    isPrime[j] =  false;
                }
            }
        }
        
        return count;
    }
}