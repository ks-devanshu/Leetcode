class Solution {
    int[] stones;
    int sum;
    int n, target;
    
    Map<String, Integer> dp = new HashMap<>();
    
    private int helper(int i, int total) {
    	if (total >= target || i >= n)
    		return Math.abs(total-(sum-total));
    	String key = i+" "+total;
    	if (dp.containsKey(key))
    		return dp.get(key);
    	
    	dp.put(key, Math.min(helper(i+1, total+stones[i]), helper(i+1, total)));
    	
    	return dp.get(key);
    }
    
    public int lastStoneWeightII(int[] stones) {
    	this.stones = stones;
    	n = stones.length;
    	
    	sum = 0;
    	for (var stone : stones)
    		sum += stone;
    	
    	target = (int)Math.ceil(sum/2);
    	
    	return helper(0, 0);
    }
}