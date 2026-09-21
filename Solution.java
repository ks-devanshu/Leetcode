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
	
	private boolean dfs(Node node, Node target) {
		if (node.value == target.value)
			return true;
		
		for (var each : node.next)
			if (dfs(each, target))
				return true;
		
		return false;
	}
	
	private Map<Integer, Node> map = new HashMap<>();
	
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i<queries.length; i++)
        	result.add(false);
        
        if (pre.length == 0)
        	return result;
        
        for (int i = 0; i<n; i++)
        	map.put(i, new Node(i));
        
        for (var req : pre)
        	addEdge(map.get(req[1]), map.get(req[0]));
        
        int i = 0;
        for (var query : queries) {
        	if (dfs(map.get(query[1]), map.get(query[0])))
        		result.set(i, true);
        	i++;
        }
        
        return result;
    }
}