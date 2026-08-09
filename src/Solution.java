public class Solution {
    private void swap(int i, int k, int[] nums) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }

    public int removeDuplicates(int[] nums) {
        int k = 0, i = 1, n = nums.length;
        while (i < n) {
            if (nums[i] != nums[k])
                swap(i,++k, nums);
            i++;
        }
        return k+1;
    }
}