class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return n;

        int i = 0, j = 1;
        // < -1 > 1 = 0
        int maxLen = 1;
        while (j < n) {
            int prev = arr[j] - arr[j-1];
            if (prev == 0) {
                i = j;
                j++;
                continue;
            }
            if (j+1 >= n) {
                maxLen = Math.max(maxLen, j-i+1);
                break;
            }
            int next = arr[j+1] - arr[j];
            if (next == 0 || (next < 0 && prev < 0) || (next > 0 && prev > 0)) {
                maxLen = Math.max(maxLen, j-i+1);
                i = j;
                j++;
                continue;
            }

            j++;
        }

        return maxLen;
    }
}