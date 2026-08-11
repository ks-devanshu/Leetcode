class Solution {
    private int[] nums;
    private int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return binarySearch(0, nums.length);
    }

    private int binarySearch(int start, int end) {
        if (start >= end) return -1;
        int mid = start + ((end-start)/2);
        if (nums[mid] == target)
            return mid;

        if (target < nums[mid])
            return binarySearch(start, mid);
        return binarySearch(mid+1, end);
    }
}