class Solution {
    public int findMinDifference(List<String> timePoints) {
        String[] tp = timePoints.toArray(new String[0]);
    	Arrays.sort(tp);
        int n = tp.length;
        int i = 1;
        int minDiff = Integer.MAX_VALUE;

        while (i < n) {
            int diff = diff(tp[i-1], tp[i]);
            if (diff == 0)
                return 0;
            minDiff = Math.min(minDiff, diff);
            i++;
        }

        int diff = diff("00:00", tp[0]) + diff(tp[n-1], "24:00");
        

        return Math.min(minDiff, diff);
    }

    private int diff(String a, String b) {
    	int aH = Integer.parseInt(a.substring(0, 2));
    	int bH = Integer.parseInt(b.substring(0, 2));
    	int aM = Integer.parseInt(a.substring(3, 5));
    	int bM = Integer.parseInt(b.substring(3, 5));
    	
    	int diff = 0;
    	if (aM > bM) {
    		diff += (60-aM)+bM;
    		bH--;
    	}
    	else
    		diff += bM - aM;
    	
    	diff += (bH-aH)*60;
    	return diff;
    }
}