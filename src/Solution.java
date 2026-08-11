class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int left = -1, right = n;

        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, i++, ++left);
            } else if (nums[i] == 2) {
                swap(nums, i, --right);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}