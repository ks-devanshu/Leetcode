class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 1) return true;
        s = s.toLowerCase().trim();
        int left = 0, right = n-1;
        while (left < right) {
            char atLeft = s.charAt(left), atRight = s.charAt(right);
            if ((atLeft < 97 && atLeft > 57) || atLeft < 48 || atLeft > 122) {
                left++;
                continue;
            }
            if ((atRight < 97 && atRight > 57) || atRight < 48 || atRight > 122) {
                right--;
                continue;
            }
            if (atLeft != atRight) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}