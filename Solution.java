class Solution {	
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = days.length;
        int[] cover = {1, 7, 30};
        for (int i = n-1; i>=0; i--) {
        	map.put(i, Integer.MAX_VALUE);
        	for (int j = 0; j<3; j++) {
        		int coverage = cover[j];
        		int k = i;
        		while (k < n && days[k] < days[i]+coverage) k++;
        		map.put(i, Math.min(map.get(i), costs[j]+map.getOrDefault(k, 0) ));
        	}
        }
        return map.get(0);
    }
}