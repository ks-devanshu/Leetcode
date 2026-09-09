class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        
        Queue<Double> max = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Double> min = new PriorityQueue<>();
        
        while (i < k) {
        	double num = nums[i];
        	if (max.size() == 0) {
        		max.add(num);
        		i++;
        		continue;
        	}
        	
        	if (max.size() == min.size()) {
        		if (num > max.peek()) {
        			min.add(num);
        			max.add(min.poll());
        		}
        		else {
        			max.add(num);
        		}
        	}
        	else {
        		max.add(num);
        		min.add(max.poll());
        	}
        	i++;
        }
        
        double[] result = new double[n-k+1];
        int j = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        result[j++] = k%2 == 1 ? max.peek() : (max.peek()+min.peek())/2;
        
        while (i < n) {
        	double prev = nums[i-k];
        	map.put(prev, map.getOrDefault(prev, 0)+1);
        	
        	int counter = 0;
        	// max +1 (add) -1 (del)
        	// min -1 (add) +1 (del)
        	// counter > 0 ? max -> min : min -> max
        	
        	if (nums[i] <= max.peek()) {
        		max.add((double) nums[i]);
        		counter++;
        	}        	
        	else {
        		min.add((double) nums[i]);
        		counter--;
        	}
        	
        	if (prev <= max.peek()) {
        		counter--;
        	}
        	else {
        		counter++;
        	}
        	
        	if (counter > 0) {
        		min.add(max.poll());
        	}
        	
        	if (counter < 0) {
        		max.add(min.poll());
        	}
        	
        	while (max.size() > 0 && map.getOrDefault(max.peek(), 0) > 0) {
        		double top = max.peek();
        		max.poll();
        		map.put(top, map.get(top)-1);
        	}
        	
        	while (min.size() > 0 && map.getOrDefault(min.peek(), 0) > 0) {
        		double top = min.peek();
        		min.poll();
        		map.put(top, map.get(top)-1);
        	}
        	
        	result[j++] = k%2 == 1 ? max.peek() : (max.peek()+min.peek())/2;
        	
        	i++;
        }
        return result;
    }
}