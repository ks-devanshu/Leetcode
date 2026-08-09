public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0, j = n, k = 0, len = nums.length;
        int[] result = new int[len];

        while (k < len) {
            if (k % 2 == 0)
                result[k++] = nums[i++];
            else
                result[k++] = nums[j++];
        }
        return result;
    }
}