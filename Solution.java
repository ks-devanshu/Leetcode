class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (k+1 >= n) return n;

        int[] map = new int[26];
        int i = 0, j = 0, maxFreq = 0, maxLen = 0;
        while (j < n) {
            int index = s.charAt(j)-'A';
            map[index]++;
            maxFreq = Math.max(maxFreq, map[index]);

            while (((j-i+1)-maxFreq) > k) {
                map[s.charAt(i)-'A']--;
                i++;
            }
            j++;
            maxLen = Math.max(maxLen, (j-i));
        }
        return maxLen;
    }
}