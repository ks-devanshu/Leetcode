class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        
        List<List<Integer>> out = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i<n; i++) {
        	if (set.contains(nums[i]))
        		continue;
        	int target = 0 - nums[i];
        	int start = i+1, end = n-1;
            Set<Integer> used = new HashSet<>();
        	while (start < end) {
        		int sum = nums[start] + nums[end];
        		if (sum == target) {
                    if (used.contains(nums[start]) && used.contains(nums[end])) {
                        start++;
                        end--;
                        continue;
                    }
        			List<Integer> list = new ArrayList<>();
        			list.add(nums[i]);
        			list.add(nums[start]);
        			list.add(nums[end]);
        			out.add(list);
        			used.add(nums[start]);
        			used.add(nums[end]);
        			start++;
        			end--;
        		}
        		else if (sum < target) {
        			start++;
        		}
        		else
        			end--;
        			
        	}
        	set.add(nums[i]);
        }
        
        return out;
    }
}