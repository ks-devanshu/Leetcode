class Solution {
	
	class UnionFind {
		class Node {
			int value, rank;
			Node parent;
			
			public Node(int value) {
				this.value = value;
				rank = 1;
				parent = this;
			}
		}
		
		Map<Integer, Node> nodes = new HashMap<>();
		int maxRank = 0;
		
		public UnionFind(int n) {
			for (int i = 0; i<n; i++)
				nodes.put(i, new Node(i));
		}
		
		
		public Node find(int i) {
			var current = nodes.get(i);
			while(current != current.parent) {
				 current.parent = current.parent.parent;
				 current = current.parent;
			}
			return current;
		}
		
		public boolean union(int a, int b) {
			Node first = find(a), second = find(b);
			
			if (first == second)
				return false;
			
			if (first.rank <= second.rank) {
				first.parent = second;
				second.rank += first.rank;
			}
			else {
				second.parent = first;
				first.rank += second.rank;
			}
			
			maxRank = Math.max(maxRank, Math.max(first.rank, second.rank));
			
			return true;
		}
		
		
	}
	
	class Edge {
		int from, to, weight, index;
		
		public Edge(int from, int to, int weight, int index) {
			this.from = from;
			this.to = to;
			this.weight = weight;
			this.index = index;
		}
	}
	
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        Edge[] sorted = new Edge[edges.length];
        
        for (int i = 0; i<edges.length; i++)
        	sorted[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        
        Arrays.sort(sorted, Comparator.comparingInt(x->x.weight));
        
        int baseMstWeight = 0;
        UnionFind uf = new UnionFind(n);
        for (var edge : sorted) {
	        if (uf.union(edge.from, edge.to)) {
	        	baseMstWeight += edge.weight;
	        }
        }
        
        List<Integer> ce = new ArrayList<>();
        List<Integer> pce = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (var edge : sorted) {
        	var remAdd = edge;
        	
        	UnionFind ex = new UnionFind(n);
        	int exWeight = 0;
        	for (var ed : sorted) {
        		if (ed == remAdd)
        			continue;
        			
        		if (ex.union(ed.from, ed.to))
        			exWeight += ed.weight;
        	}
        	
        	if (ex.maxRank != n || exWeight > baseMstWeight){
        		ce.add(remAdd.index);
        		continue;
        	}
        	
        	var add = new UnionFind(n);
        	int addWeight = remAdd.weight;
        	add.union(remAdd.from, remAdd.to);
        	for (var ed : sorted) {
        		if (add.union(ed.from, ed.to))
        			addWeight += ed.weight;
        	}
        	
        	if (addWeight == baseMstWeight) {
        		pce.add(remAdd.index);
        	}
        }
        
        result.add(ce);
        result.add(pce);
        
        
        return result;
    }
}