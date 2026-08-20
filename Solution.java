class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[] row = new int[m];
        int i = 0;

        while (i < n) {
            int left = 0;
            int[] temp = new int[m];
            for (int j = 0; j<m; j++){
                temp[j] = Math.max(row[j], left);

                if (text1.charAt(j) == text2.charAt(i)) {
                    if (j - 1 < 0 ) temp[j] = 1;
                    else {
                        temp[j] = row[j-1] + 1;
                    }
                }

                left = temp[j];
            }
            row = temp;
            i++;
        }

        if ((m == 1 || n == 1) && row[m-1] > 0) return 1;
        return row[m-1];
    }
}