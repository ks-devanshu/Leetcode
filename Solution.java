class Solution {
    char[][] board;
    String word;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (doExist(i, j, new HashSet<>(), 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean doExist(int row, int col, Set<String> set, int i) {
        if (row < 0 || row >= m || col < 0 || col >= n) return false;
        if (set.contains(row+" "+col)) return false;
        if (i >= word.length()) return false;
        if (board[row][col] != word.charAt(i)) return false;

        set.add(row+" "+col);
        if (i+1 >= word.length() && board[row][col] == word.charAt(i)) return true;

        boolean result = doExist(row, col+1, set, i+1) || doExist(row, col-1, set, i+1) || doExist(row+1, col, set, i+1) || doExist(row-1, col, set, i+1);

        set.remove(row+" "+col);

        return result;
    }
}