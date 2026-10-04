class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = (int) Math.pow(grid.length, 2);
        
        long sum = 0, sqSum = 0;
        for (var row : grid)
        	for (var num : row) {
        		sum += num;
        		sqSum += (num*num);
        	}
        
        long eSum = (n*(n+1))/2L;
        long esqSum = ((n * (n+1L))*((2*n)+1L))/6L;
        
        long aMb = sum - eSum;
        long aPb = sqSum - esqSum;
        long fsum = aPb / aMb;
        
        int a = (int)(fsum + aMb)/2;
        int b = (int)fsum - a;
        
        int[] out = new int[2];
        out[0] = a;
        out[1] = b;
        return out;
    }
}