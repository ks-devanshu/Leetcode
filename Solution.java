class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long mod = 1_000_000_007L;
		long totalSum = 0L;
		for (int i = 0; i<n; i++)
			totalSum += arr[i];
		
		int copies = Math.min(k, 2);
		long maxSub = 0L, current = 0L;
		
		for (int i = 0 ; i<n*copies; i++) {
			current = Math.max(0L, current+arr[i%n]);
			maxSub = Math.max(maxSub, current);
		}
		
		if (k <= 2)
			return (int) (maxSub % mod);
		
		if (totalSum > 0) {
			long total = maxSub + ((k-2) * totalSum);
			return (int) (total % mod);
		}
		
		return (int) (maxSub % mod);
    }
}