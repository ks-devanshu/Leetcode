import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    // DFS
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return clone(node);
    }

    private Node clone(Node node) {
        if (map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (var adj : node.neighbors)
            copy.neighbors.add(clone(adj));

        return copy;
    }

    //BFS
    // public Node cloneGraph(Node node) {
    //     if (node == null) return null;

    //     Queue<Node> queue = new ArrayDeque<>();
    //     Map<Node, Node> map = new HashMap<>();
    //     Set<Integer> set = new HashSet<>();
    //     queue.add(node);

    //     while(!queue.isEmpty()) {
    //         Node ref = queue.remove();
    //         Node copy = map.containsKey(ref) ? map.get(ref) : new Node(ref.val);
    //         map.putIfAbsent(ref, copy);

    //         for (var adj : ref.neighbors) {
    //             map.putIfAbsent(adj, new Node(adj.val));
    //             copy.neighbors.add(map.get(adj));
    //             if (!set.contains(adj.val)) {
    //                 queue.add(adj);
    //                 set.add(adj.val);
    //             }
    //         }
    //         set.add(copy.val);
    //     }
    //     return map.get(node);
    // }
}