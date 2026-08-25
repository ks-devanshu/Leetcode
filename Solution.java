class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int left = 0, right = n-1, leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;
        while (left < right) {
            if (leftMax <= rightMax) {
                trappedWater += Math.max(0, leftMax - height[left]);
                if (height[left] > leftMax) leftMax = height[left];
                else left++;
            }
            else {
                trappedWater += Math.max(0, rightMax - height[right]);
                if (height[right] > rightMax) rightMax = height[right];
                else right--;
            }
        }
        return trappedWater;
    }
}