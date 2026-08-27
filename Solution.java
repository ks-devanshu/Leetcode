class WordDictionary {

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

    public WordDictionary() {
        root = new Node(' ');
    }

    public void addWord(String word) {
        var current = root;
        for (var alpha : word.toCharArray()) {
            current.map.putIfAbsent(alpha, new Node(alpha));
            current = current.map.get(alpha);
        }
        current.isEndOfWord = true;
    }

    private boolean search(Node start, String word) {
        int n = word.length();
        Node current = start;
        for (int i = 0; i<n; i++) {
            char alpha = word.charAt(i);
            if (alpha == '.') {
                for (var next : current.map.values()) {
                    if (search(next, word.substring(i+1, n))) return true;
                }
            }
            if (!current.map.containsKey(alpha)) return false;
            current = current.map.get(alpha);
        }
        return current.isEndOfWord;
    }

    public boolean search(String word) {
        return search(root, word);
    }
}