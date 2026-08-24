class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int i = 0, j = 0,count = 0;
        int sum = 0;
        while (j <= n) {
            if (j-i >= k) {
                if ((sum/k) >= threshold) count++;
                sum -= arr[i];
                i++;
            }
            if (j >= n) break;
            sum += arr[j];
            j++;
        }
        return count;
    }
}