public class Solution {
    public int[] getConcatenation(int[] nums) {
        int i = 0, n = nums.length;
        int[] result = new int[2*n];
        while (i < n) {
            result[i] = nums[i];
            result[n+i] = nums[i];
            i++;
        }

        return result;
    }
}