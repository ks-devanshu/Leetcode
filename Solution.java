class WordFilter {

    private class Node{
        char value;
        int index;
        Node parent;
        Map<Character, Node> children;

        public Node(char value, Node parent) {
            this.value = value;
            index = -1;
            this.parent = parent;
            children = new HashMap<>();
        }
    }

    private Node root = new Node(' ', null);

    private void insert(String word, int index) {
        Node current = root;
        for (int i = 0; i<word.length(); i++) {
            char alpha = word.charAt(i);
            current.children.putIfAbsent(alpha,new Node(alpha, current));
            current = current.children.get(alpha);
        }
        current.index = index;
    }

    public WordFilter(String[] words) {
        for (int i = 0; i<words.length; i++)
            insert(words[i], i);
    }

    private String pref, suff;
    private Set<Integer> set = new HashSet<>();

    public int f(String pref, String suff) {
        this.pref = pref;
        this.suff = suff;

        matchPrefix(0, root);

        int maxIndex = -1;

        for (var index : set) {
            maxIndex = Math.max(maxIndex, index);
        }

        return maxIndex;
    }


    private void matchSuffix(Node node) {
        for (var child : node.children.values())
            matchSuffix(child);

        if (node.index > -1) {
            Node current = node;
            int i = suff.length() - 1;
            while (i >= 0 && current.value == suff.charAt(i)) {
                current = current.parent;
                i--;
            }
            if (i <= 0)
                set.add(node.index);
        }
    }


    private void matchPrefix(int i, Node node) {
        if (i >= pref.length()) {
            matchSuffix(node);
            return;
        }

        char alpha = pref.charAt(i);
        if (node.children.containsKey(alpha))
            matchPrefix(i+1, node.children.get(alpha));
    }
}