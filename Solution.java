class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i<=amount+1; i++)
        	map.put(i, amount+1);
        
        for (int i = 1; i <= amount; i++) {
        	for (var coin : coins)
        		if (i - coin >= 0)
        			map.put(i, Math.min(map.get(i), 1+map.get(i-coin)));
        }
        
        return map.get(amount) != amount+1 ? map.get(amount) : -1;
    }
}