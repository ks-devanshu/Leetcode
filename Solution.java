import java.util.Map;
import java.util.HashMap;

class LRUCache {
    
    private class Node {
        private int key, value;
        private Node prev, next;
        
        public Node() {}
        
        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
    
    private void addToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        
        tail.prev = node;
        node.prev.next = node;
    }
    
    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity, count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        var node = map.get(key);
        delete(node);
        addToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            var node = map.get(key);
            delete(node);
            node.value = value;
            addToTail(node);
        }
        else {
            var node = new Node(key, value);
            map.put(key, node);
            addToTail(node);
            count++;
            if (count > capacity) {
                int toRem = head.next.key;
                delete(head.next);
                map.remove(toRem);
                count--;
            }
        }
    }
}