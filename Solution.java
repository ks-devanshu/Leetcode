class KthLargest {
Queue<Integer> queue = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for (var each : nums) {
            queue.add(each);
            
            if (queue.size() > k)
                queue.remove();
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if (queue.size() > k)
            queue.remove();
        return queue.peek();
    }
}