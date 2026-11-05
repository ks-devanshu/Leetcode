class Solution {
	private class Pair {
		int num, sum;
		public Pair(int num, int sum) {
			this.num = num;
			this.sum = sum;
		}
	}
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        
        int max = nums[0];
        for (var num : nums)
        	max = Math.max(max, num);
        
        Pair[] pairs = new Pair[max+1];
        for (int i = 2; i<=max; i++) {
        	for (int j = i; j<=max; j += i) {
        		if (pairs[j] == null) {
        			pairs[j] = new Pair(1, i);
        		}
        		else {
        			pairs[j].num += 1;
        			pairs[j].sum += i;
        		}
        	}
        }

        int sum = 0;
        for (var num : nums) {
            if (num == 1)
                continue;
        	if (pairs[num].num == 3)
        		sum += pairs[num].sum+1;
        }
        
        return sum;
    }
}