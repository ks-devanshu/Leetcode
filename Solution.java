class Solution {
    public boolean lemonadeChange(int[] bills) {
    	int n = bills.length;
        int[] deno = new int[2];
        
        for (int bill : bills) {
        	int change = bill - 5;
        	if (change == 0) {
        		deno[0]++;
        	}
        	else if (change == 5 && deno[0] > 0) {
        		deno[0]--;
        		deno[1]++;
        	}
        	else if (change == 15 && ((deno[0] > 0 && deno[1] > 0) || (deno[0] > 2))) {
        		if (deno[1] > 0) {
        			deno[0]--;
        			deno[1]--;
        		}
        		else
        			deno[0] -= 3;
        	}
        	else
        		return false;
        }
        
        return true;
    }
}