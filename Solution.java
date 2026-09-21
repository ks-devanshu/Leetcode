class Solution {
	private class Node {
		private int value;
		private Set<Node> next;
		
		public Node(int value) {
			this.value = value;
			next = new HashSet<>();
		}
	}
	
	private void addEdge(Node from, Node to) {
		from.next.add(to);
	}
	
	private Set<Integer> visited = new HashSet<>();
	private Stack<Integer> stack = new Stack<>();
	
	private boolean topOrder(Node node, Set<Integer> prev) {
		if (prev.contains(node.value))
			return false;
		if (visited.contains(node.value))
			return true;
		
		prev.add(node.value);
		for (var each : node.next)
			if (!topOrder(each, prev))
				return false;
		
        prev.remove(node.value);
		stack.push(node.value);
		visited.add(node.value);
		
		return true;
	}
	
	private Map<Integer, Node> map = new HashMap<>();
	
    public int[] findOrder(int n, int[][] pre) {
        int[] result = new int[n];
        
        for (int i = 0; i<n; i++) {
        	map.put(i, new Node(i));
        	result[i] = i;
        }
        
        if (pre.length == 0)
        	return result;
        
        for (var req : pre) {
        	addEdge(map.get(req[1]), map.get(req[0]));
        }
        
        for (int i = 0; i<n; i++) {
        	if (!topOrder(map.get(i), new HashSet<>())) {
        		int[] impossible = new int[0];
        		return impossible;
        	}
        }
        
        int i = 0;
        while (!stack.isEmpty())
        	result[i++] = stack.pop();
        
        return result;
    }
}