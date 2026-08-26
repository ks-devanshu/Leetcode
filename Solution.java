class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m][n];
        for (int i = 0; i<m; i++) {
            int sum = 0;
            for (int j = 0; j<n; j++) {
                sum += matrix[i][j];
                int upper = (i-1) < 0 ? 0 : prefix[i-1][j];
                prefix[i][j] = sum+upper;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int botLeft = prefix[row2][col2];
        int result = botLeft - ( (row1 - 1 < 0) ? 0 : prefix[row1-1][col2]) - ( (col1-1 < 0) ? 0 : prefix[row2][col1-1]) + ( (row1-1 < 0 || col1-1 < 0) ? 0 : prefix[row1-1][col1-1]);
        return result;
    }
}