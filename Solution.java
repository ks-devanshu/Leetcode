class Solution {
    public int countPairs(int[] nums) {
    	Arrays.sort(nums);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
			Set<Integer> set = new HashSet<>();
        	set.add(num);
			StringBuilder word = new StringBuilder(num+"");
        	for (int i = 0; i<word.length(); i++) {
        		for (int j = i+1; j<word.length(); j++) {
        			var temp = new StringBuilder(word);
        			var prev = temp.charAt(j);
        			temp.setCharAt(j, temp.charAt(i));
        			temp.setCharAt(i, prev);
        			int out = Integer.parseInt(temp.toString());
        			set.add(out);
        		}
        	}
        	
        	for (var each : set) {
        		count += map.getOrDefault(each, 0);
        	}
        	
        	map.put(num, map.getOrDefault(num, 0)+1);
    	}
    	
    	return count;
    	
    }
}