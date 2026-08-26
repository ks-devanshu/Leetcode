class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], postfix = new int[n];
        int preProduct = 1, postProduct = 1;
        for (int i = 0; i<n; i++) {
            preProduct *= nums[i];
            prefix[i] = preProduct;
            postProduct *= nums[n-i-1];
            postfix[n-i-1] = postProduct;
        }

        int[] result = new int[n];
        for (int i = 0; i<n; i++) {
            result[i] = ( i-1 < 0 ? 1 : prefix[i-1]) * ( i+1 >= n ? 1 : postfix[i+1]);
        }

        return result;
    }
}