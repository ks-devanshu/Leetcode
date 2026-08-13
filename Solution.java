class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (var stone : stones) {
            queue.add(stone);
        }
        
        while (queue.size() > 1) {
            int y = queue.remove();
            int x = queue.remove();
            
            if (x == y) continue;
            
            queue.add(y-x);
        }
        
        if (queue.size() > 0) return queue. remove();
        return 0;
    }
}