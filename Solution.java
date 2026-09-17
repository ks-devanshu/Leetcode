class Solution {
	class Pair {
		int node;
		double prob;
		
		public Pair(int node, double prob) {
			this.node = node;
			this.prob = prob;
		}
	}
	
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, Set<Pair>> map = new HashMap<>();
        
        for (int i = 0; i<n; i++)
        	map.put(i, new HashSet<>());
        
        int i = 0;
        for (var edge : edges) {
        	map.get(edge[0]).add(new Pair(edge[1], succProb[i]));
        	map.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        	i++;
        }
        
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingDouble(x -> x.prob ));
        queue.add(new Pair(start_node, (double) -1));
        Set<Integer> set = new HashSet<>();
        
        while(!queue.isEmpty()) {
        	var current = queue.poll();
        	if (set.contains(current.node))
        		continue;
        	
        	set.add(current.node);
        	
        	if (current.node == end_node)
        		return (-1)*current.prob;
        	
        	for (var next : map.get(current.node)) {
        		next.prob = Math.max((-1)*next.prob, current.prob*next.prob);
        		queue.add(next);
        	}
        }
        
        return 0;
    }
}