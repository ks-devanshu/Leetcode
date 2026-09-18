class Solution {
    class Trie {
        class Node {
            char value;
            boolean isEnd;
            Map<Character, Node> next;

            public Node(char value) {
                this.value = value;
                isEnd = false;
                next = new HashMap<>();
            }
        }

        private Node root = new Node(' ');

        public void add(String word) {
            var current = root;
            int i = 0, n = word.length();
            while (i < n) {
                char alpha = word.charAt(i);
                if (!current.next.containsKey(alpha)) {
                    current.next.put(alpha, new Node(alpha));
                }

                current = current.next.get(alpha);
                i++;
            }
            current.isEnd = true;
        }

        public String prefix() {
            var current = root;
            StringBuilder out = new StringBuilder();
            while (current.next.size() == 1 && !current.isEnd) {
                for (var n : current.next.values())
                    current = n;
                out.append(current.value);
            }

            return out.toString();
        }
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (var s : strs) {
            if (s.equals(""))
                return s;
            trie.add(s);
        }
        
        return trie.prefix();
    }
}