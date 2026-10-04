class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int max = 0;
        
        for (int i = n-1; i>=0; i--) {
        	profit = Math.max(profit, max - prices[i]);
        	max = Math.max(max, prices[i]);
        }
        
        return profit;
    }
}