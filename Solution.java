class Solution {
    int[] coins;
    int n;
    
    Map<String, Integer> map = new HashMap<>();
    private int helper(int i, int amount) {
    	if (amount == 0)
    		return 1;
    	if (i >= n || amount < 0)
    		return 0;
    	String key = i+" "+amount;
    	if (map.containsKey(key))
    		return map.get(key);
    	
    	map.put(key, helper(i+1, amount) + helper(i, amount-coins[i]));
    	return map.get(key);
    }
    
    public int change(int amount, int[] coins) {
        this.coins = coins;
        n = coins.length;
        
        return helper(0, amount);
    }
}