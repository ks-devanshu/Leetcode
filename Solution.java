class Solution {
    class Node{
        private int value;
        private List<Node> req = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addReq(Node ment) {
            req.add(ment);
        }
    }



    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        Map<Integer, Node> map = new HashMap<>();

        for (var ind : prerequisites) {
            int base = ind[0], top = ind[1];
            if (!map.containsKey(base))
                map.put(base, new Node(base));
            if (!map.containsKey(top))
                map.put(top, new Node(top));

            Node baseN = map.get(base), topN = map.get(top);

            topN.addReq(baseN);
        }

        for (var each : map.values()) {
            if (hasCycle(each, new HashSet<>())) return false;
        }

        return true;
    }

    Map<Integer, Boolean> dp = new HashMap<>();

    private boolean hasCycle(Node node, Set<Integer> set) {
        if (dp.containsKey(node.value)) return dp.get(node.value);
        if (set.contains(node.value)) return true;

        set.add(node.value);

        boolean cycle = false;
        for (var adj : node.req)
            cycle = cycle || hasCycle(adj, set);

        set.remove(node.value);
        dp.put(node.value, cycle);
        return cycle;
    }
}