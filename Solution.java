class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return n;

        int maxLen = Integer.MIN_VALUE;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (j < n) {
            if (set.contains(s.charAt(j))) {
                maxLen = Math.max(maxLen, set.size());
            }

            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            j++;
        }

        return maxLen;
    }
}