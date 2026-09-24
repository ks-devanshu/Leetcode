class Solution {
	class Node {
		char value;
		Set<Node> next;

		public Node(char value) {
			this.value = value;
			next = new HashSet<>();
		}
	}
	private Map<Character, Node> map = new HashMap<>();

	private void addEdge(Node from,Node to) {
		from.next.add(to);
	}

	private Set<Character> visited = new HashSet<>();
	private Stack<Character> stack = new Stack<>();

	private boolean topSort(Node node, Set<Character> visiting) {
		if (visiting.contains(node.value))
			return false;
		if (visited.contains(node.value))
			return true;

		visiting.add(node.value);
		for (var nx : node.next) {
			if (!topSort(nx, visiting))
				return false;
		}
		visiting.remove(node.value);
		visited.add(node.value);
		stack.push(node.value);
		return true;
	}

    public String findOrder(String[] words) {
        int n = words.length;

        for (var word : words)
        	for (var ch : word.toCharArray())
        		map.put(ch, new Node(ch));

        for (int i = 0; i<n-1; i++) {
        	String before = words[i], after = words[i+1];
        	int j = 0, k = 0;
        	while (j< before.length() && k < after.length() && before.charAt(j) == after.charAt(k)) {
        		j++;
        		k++;
        	}
        	if (k >= after.length())
        	    return "";
        	if (j >= before.length())
        	    continue;
        	addEdge(map.get(before.charAt(j)), map.get(after.charAt(k)));
        }

        for (var node : map.values()) {
        	if (!topSort(node, new HashSet<>()))
        		return "";
        }

        String out = "";
        while(!stack.isEmpty())
        	out += stack.pop();

        return out;
    }
}