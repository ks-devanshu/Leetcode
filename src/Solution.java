public class Solution {
    private void swap(int i, int k, int[] nums) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int k = 0, i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] != val)
                swap(i, k++, nums);
            i++;
        }
        return k;
    }
}