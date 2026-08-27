class Trie {

    class Node {
        char value;
        Map<Character, Node> map;
        boolean isEndOfWord = false;

        public Node(char value) {
            this.value = value;
            map = new HashMap<>();
        }
    }

    private Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String word) {
        var current = root;
        for (var alpha : word.toCharArray()) {
            current.map.putIfAbsent(alpha, new Node(alpha));
            current = current.map.get(alpha);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        var current = root;
        for (var alpha : word.toCharArray()) {
            if (!current.map.containsKey(alpha))
                return false;
            current = current.map.get(alpha);
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        var current = root;
        for (var alpha : prefix.toCharArray()) {
            if (!current.map.containsKey(alpha))
                return false;
            current = current.map.get(alpha);
        }
        return true;
    }
}