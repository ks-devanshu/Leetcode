class Solution {
    public String[] createGrid(int m, int n) {
    	String[] out = new String[m];
        if (m == 1) {
        	StringBuilder res = new StringBuilder();
        	for(int i = 0; i<n; i++)
        		res.append(".");
        	out[0] = res.toString();
        	return out;
        }
        
        if (n == 1) {
        	for (int i = 0; i<m; i++) {
        		out[i] = ".";
        	}
        	
        	return out;
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i<n; i++)
        	res.append(".");
        out[0] = res.toString();
        
        for (int i = 1; i<m; i++) {
        	res = new StringBuilder();
        	for (int j = 0; j<n-1; j++) {
        		res.append("#");
        	}
        	res.append(".");
        	out[i] = res.toString();
        }
        
        return out;
    }
}