class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
		int min = Integer.MAX_VALUE;

		int left = 0, right = n-1;
		while (right-left > 1) {
			int mid = left + ((right-left)/2);
			int a = nums[left], b = nums[mid], c = nums[right];
			min = Math.min(min, Math.min(b, Math.min(a, c)));
			if (b > a && b > c) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		min = Math.min(min, Math.min(nums[left], nums[right]));
		return min;
    }
}