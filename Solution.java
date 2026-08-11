class Solution {
    private int[][] matrix;
    private int target;
    private int m,n;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        m = matrix.length;
        n = matrix[0].length;
        
        int row = binarySearchOnMatrix(0, m);
        
        if (row < 0) return false;
        
        return binarySearch(matrix[row], 0, n);
    }
    
    private int binarySearchOnMatrix(int start, int end) {
        if (start >= end) return -1;
        int mid = start + ((end-start)/2);
        
        if (target >= matrix[mid][0] && target <= matrix[mid][n-1]) return mid;
        if (target < matrix[mid][0]) return binarySearchOnMatrix(start, mid);
        return binarySearchOnMatrix(mid+1, end);
    }
    
    private boolean binarySearch(int[] nums, int start, int end) {
        if (start >= end) return false;
        int mid = start + ((end-start)/2);
        
        if (nums[mid] == target) return true;
        if (target < nums[mid]) return binarySearch(nums, start, mid);
        return binarySearch(nums, mid+1, end);
    }
}