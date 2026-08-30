class Solution {
    class Node {
        int index;
        Node parent;
        int rank;

        public Node(int index) {
            this.index = index;
            parent = this;
            rank = 1;
        }
    }

    private Map<Integer, Node> nodemap = new HashMap<>();

    private Node findParent(int node) {
        Node current = nodemap.get(node);
        while (current.parent != current) {
            current.parent = current.parent.parent;
            current = current.parent;
        }
        return current;
    }

    public void merge(int f, int s) {
        Node first = findParent(f), second = findParent(s);

        if (first.rank < second.rank) {
            first.parent = second;
            second.rank++;
        }
        else {
            second.parent = first;
            first.rank++;
        }
    }

    private Map<String, Integer> mailmap = new HashMap<>();
    private Map<Integer, List<String>> indexToMail = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i<accounts.size(); i++) {
            nodemap.put(i, new Node(i));
            for (var email : accounts.get(i).subList(1, accounts.get(i).size())) {
                if (mailmap.containsKey(email)) {
                    merge(i, mailmap.get(email));
                }
                else {
                    mailmap.put(email, i);
                }
            }
            indexToMail.put(i, new ArrayList<>());
        }

        for (var email : mailmap.keySet()) {
            var index = findParent(mailmap.get(email)).index;
            indexToMail.get(index).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (var index : indexToMail.keySet()) {
            var pre = indexToMail.get(index);
            if (pre.size() == 0)
                continue;
            pre.sort(null);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(index).get(0));
            list.addAll(pre);
            result.add(list);
        }

        return result;

    }
}