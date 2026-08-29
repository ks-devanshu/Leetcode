class Solution {
    private class Node {
        private Node parent;
        private int rank;

        public Node() {
            parent = this;
            rank = 1;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();

    private Node findParent(Node node) {
        Node current = node;
        while (current.parent != current) {
            current.parent = current.parent.parent;
            current = current.parent;
        }
        return current;
    }

    private boolean union(Node first, Node second) {
        Node p1 = findParent(first), p2 = findParent(second);
        int rankOne = p1.rank, rankTwo = p2.rank;

        if (p1 == p2) {
            return false;
        }

        if (rankOne < rankTwo) {
            p1.parent = p2;
        }
        else if (rankOne > rankTwo) {
            p2.parent = p1;
        }
        else {
            p1.parent = p2;
            p2.rank++;
        }

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];

        for (var edge : edges) {
            map.putIfAbsent(edge[0], new Node());
            map.putIfAbsent(edge[1], new Node());
            if (!union(map.get(edge[0]), map.get(edge[1]))) {
                result[0] = edge[0];
                result[1] = edge[1];
            }
        }

        return result;
    }
}