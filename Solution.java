class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int left = 0, right = 0, last = nums[0], lastCount = 0;
        while (right < n) {
            if (nums[right] == last) lastCount++;
            else {
                last = nums[right];
                lastCount = 1;
            }
            if (left < right) nums[left] = nums[right];
            if (lastCount <= 2) left++;
            right++;
        }
        return left;
    }
}