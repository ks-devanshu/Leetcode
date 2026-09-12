class Solution {
	
	class Edge{
		Node source, dest;
		int weight;
		
		public Edge(Node source, Node dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	class Node {
		int value;
		List<Edge> edges;
		
		public Node(int value) {
			this.value = value;
			edges = new ArrayList<>();
		}
		
		public void addEdge(Node dest, int weight) {
			edges.add(new Edge(this, dest, weight));
		}
		
		@Override
		public String toString() {
			return value+"";
		}
	}
	
	Map<Integer, Node> map = new HashMap<>();
	
	class Pair {
		Node node;
		int distance;
		
		public Pair(Node node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
	
	public int networkDelayTime(int[][] times, int n, int k) {
		for (int i = 1; i<=n; i++)
			map.put(i, new Node(i));
		
		for (var time : times) {
			Node source = map.get(time[0]);
			Node dest = map.get(time[1]);
			int weight = time[2];
			
			source.addEdge(dest, weight);
		}
		
		Map<Integer,Integer> shortest = new HashMap<>();
		
		shortest.put(k, 0);
		for (int i = 1; i<=n; i++)
			shortest.putIfAbsent(i, Integer.MAX_VALUE);
		
		Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
		queue.add(new Pair(map.get(k), shortest.get(k)));
		
		Set<Node> visited = new HashSet<>();
		
		while(!queue.isEmpty()) {
			Node current = queue.poll().node;
			if (visited.contains(current))
				continue;
			for (var edge : current.edges) {
				shortest.replace(edge.dest.value, Math.min(shortest.get(edge.dest.value), shortest.get(current.value)+edge.weight));
				queue.add(new Pair(map.get(edge.dest.value), shortest.get(edge.dest.value)));
			}
			visited.add(current);
		}
		
		if (visited.size() < n)
			return -1;
		
		int max = 0;
		for (int distance : shortest.values())
			max = Math.max(max, distance);
		
		return max;
   }
}