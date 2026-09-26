class Solution {
    String[] strs;
    int size, m, n;
    Map<Integer, String> zoCnt = new HashMap<>();
    Map<String, Integer> dp = new HashMap<>();
    
    private int helper(int i, int m, int n) {
    	if (i >= size)
    		return 0;
    	String help = i+" "+m+" "+n;
    	if (dp.containsKey(help))
    		return dp.get(help);
    	
    	dp.put(help, helper(i+1, m , n));
    	var str = zoCnt.get(i).split(" ");
    	int z = Integer.parseInt(str[0]);
    	int o = Integer.parseInt(str[1]);
    	
    	if (z <= m && o <= n) {
    		dp.replace(help ,
    			Math.max(dp.get(help),
    				1 + helper(i+1, m-z, n-o))
    		);
    	}
    	
    	return dp.get(help);
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        this.strs = strs;
        size = strs.length;
        this.m = m;
        this.n = n;
        
        for (int i = 0; i<size; i++) {
        	var str = strs[i];
        	int z = 0, o = 0;
        	for (var ch : str.toCharArray())
        		if (ch == '0')
        			z++;
        		else
        			o++;
        	zoCnt.put(i,z+" "+o);
        }
        
        return helper(0, m, n);
        
    }
}