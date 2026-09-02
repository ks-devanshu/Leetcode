class Solution {
    class Node {
        int rank;
        Node parent;

        public Node() {
            parent = this;
            rank = 1;
        }
    }

    Map<Integer, Node> nodemap = new HashMap<>();

    private Node findParent(int value) {
        Node node = nodemap.get(value);
        while (node.parent != node) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    private void union(int f, int s) {
        Node first = findParent(f), second = findParent(s);

        if (first == second) return;

        if (first.rank < second.rank) {
            first.parent = second;
            second.rank++;
        }
        else {
            second.parent = first;
            first.rank++;
        }
    }

    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        for (int i = 0; i < V; i++) {
            nodemap.put(i, new Node());
        }

        for (var edge : edges) {
            union(edge.get(0), edge.get(1));
        }

        int count = 0;
        for (var node : nodemap.values())
            if (node.parent == node)
                count++;

        return count;
    }
}