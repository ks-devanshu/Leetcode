class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLength = 1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n-1; i>=0; i--) {
            int localMax = 1;
            for (int j = i+1; j<n; j++) {
                if (nums[j] > nums[i])
                    localMax = Math.max(localMax, 1+map.get(j));
            }
            map.put(i, localMax);
            maxLength = Math.max(maxLength, localMax);
        }

        return maxLength;
    }
}