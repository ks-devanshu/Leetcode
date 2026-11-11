class Solution {
	class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length)
            return 0;
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(x->x.b));
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr)
        	map.put(item, map.getOrDefault(item, 0)+1);
        if (k == 0)
            return map.size();

        for (var key : map.keySet())
        	queue.add(new Pair(key, map.get(key)));
        
        while (k > 0) {
            var left = queue.peek();
            if (left.b <= k) {
                k -= left.b;
                queue.poll();
            }
            else
                return queue.size();
        }
        
        return queue.size();
    }
}