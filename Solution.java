class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m > n) return -1;

        int i = 0, j = 0;
        while (i < n) {
            int temp = i;
            while(i< n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            }
            if (j == m) {
                return i-j;
            }

            i = temp+1;
            j = 0;
        }

        return -1;
    }
}