class MedianFinder {
	
	Queue<Double> max, min;

    public MedianFinder() {
    	max = new PriorityQueue<>(Comparator.reverseOrder());
    	min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.add((double)num);
        
        if (max.size() - min.size() > 1) {
        	min.add(max.poll());
        }
        
        if (min.peek() != null && max.peek() > min.peek()) {
        	min.add(max.poll());
        }
        
        if (min.size() - max.size() > 1) {
        	max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size())
        	return max.peek();
        else if (min.size() > max.size())
        	return min.peek();
        else
        	return (max.peek()+min.peek())/2;
    }
}