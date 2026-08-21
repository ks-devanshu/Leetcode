class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int i = 0, maxSum = nums[0];

        int currentSum = 0;
        while (i < n) {
            currentSum = Math.max(currentSum, 0);
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            i++;
        }

        return maxSum;
    }
}