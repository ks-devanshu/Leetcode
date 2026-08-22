class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, maxSum = nums[0], minSum = nums[0], currMax = 0, currMin = 0;
        int i = 0, totalSum = 0;

        while (i < n) {
            totalSum += nums[i];
            currMax = Math.max(currMax, 0);
            currMax += nums[i];
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin, 0);
            currMin += nums[i];
            minSum = Math.min(minSum, currMin);
            i++;
        }

        if (maxSum < 0) return maxSum;

        return Math.max( maxSum, totalSum - minSum );
    }
}