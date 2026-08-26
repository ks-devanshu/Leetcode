class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int[] prefix = new int[n];
        int sum = 0;
        for (int i = 0; i<n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        for (int i = 0; i<n; i++) {
            int prev = (i-1) < 0 ? 0 : prefix[i-1];
            if (prev == (prefix[n-1] - prefix[i])) return i;
        }
        return -1;
    }
}