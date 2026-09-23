class Solution {
	class Node {
		int value;
		Set<Node> next;
		
		public Node(int value) {
			this.value = value;
			next = new HashSet<>();
		}
	}
	
	private void addEdge(Node from, Node to) {
		from.next.add(to);
	}
	
	private Set<Integer> set = new HashSet<>();
	private Stack<Integer> stack = new Stack<>();
	
	private boolean topSort(Node node, Set<Integer> prev) {
        if (node == null)
            return true;
		if (prev.contains(node.value))
			return false;
		if (set.contains(node.value))
			return true;
		
		prev.add(node.value);
		
		for (var next : node.next)
			if(!topSort(next, prev))
				return false;
		
		prev.remove(node.value);
		set.add(node.value);
		stack.push(node.value);
		return true;
	}
	
	private Map<Integer, Node> nodes = new HashMap<>();
	private Map<Integer, Node> groups = new HashMap<>();
	private Map<Integer, Integer> nTg = new HashMap<>();
	private Map<Integer, List<Integer>> gTn = new HashMap<>();
	
	private int[] impossible() {
		int[] out = new int[0];
		return out;
	}
	
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i<n; i++)
        	nodes.put(i, new Node(i));
        
        for (int i = 0; i<beforeItems.size(); i++) {
        	for (var before : beforeItems.get(i))
        		addEdge(nodes.get(i), nodes.get(before));
        }
        
        for (int i = 0; i<n; i++) {
        	if(!topSort(nodes.get(i), new HashSet<>())) {
        		return impossible();
        	}
        }
        
        int[] bSort = new int[n];
        int b = n;
        while(!stack.isEmpty())
        	bSort[--b] = stack.pop();
        
        set.clear();
        
        int temp = m;
        for (int i = 0; i<n; i++) {
        	int ind = group[i];
        	if(ind < 0)
        		ind = temp++;
        	groups.put(ind, new Node(ind));
        	nTg.put(i, ind);
        }
        
        for (int i = 0; i<n; i++) {
        	for (var before : beforeItems.get(i)) {
        		int from = nTg.get(before), to = nTg.get(i);
        		if (from == to)
        			continue;
        		addEdge(groups.get(from) , groups.get(to));
        	}
        }
        
        for (int i = 0; i<temp; i++) {
        	if (!topSort(groups.get(i), new HashSet<>()))
        		return impossible();
        }
        
        int[] gSort = new int[stack.size()];
        int g = 0;
        while (!stack.isEmpty())
        	gSort[g++] = stack.pop();
        
        for (int i = 0; i<temp; i++) {
        	gTn.put(i, new ArrayList<>());
        }
        
        for (var item : bSort) {
        	gTn.get(nTg.get(item)).add(item);
        }
        
        b = 0;
        for (var gr : gSort) {
        	for (var it : gTn.get(gr)) {
        		bSort[b++] = it;
            }
        }
        
        return bSort;
    }
}