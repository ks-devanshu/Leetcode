public class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return nums;

        int[] left = new int[n / 2];
        int[] right = new int[n - (n / 2)];

        for (int i = 0; i < n; i++) {
            if (i < n / 2)
                left[i] = nums[i];
            else
                right[i - (n / 2)] = nums[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        int[] sorted = new int[n];
        int i = 0, j = 0, k = 0;
        while (k < n) {
            if (i >= left.length) {
                sorted[k++] = right[j++];
                continue;
            }
            if (j >= right.length) {
                sorted[k++] = left[i++];
                continue;
            }

            if (left[i] <= right[j])
                sorted[k++] = left[i++];
            else
                sorted[k++] = right[j++];
        }
        return sorted;
    }
}