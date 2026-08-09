class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private final Node dummy;
    private int count;

    public MyLinkedList() {
        dummy = new Node();
    }

    public int get(int index) {
        if (index < 0 || index >= count) return -1;
        var current = dummy.next;
        while (index-- > 0) current = current.next;
        return current.value;
    }

    public void addAtHead(int val) {
        dummy.next = new Node(val, dummy.next);
        count++;
    }

    public void addAtTail(int val) {
        var current = dummy;
        while (current.next != null) current = current.next;
        current.next = new Node(val);
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > count) return;
        if (index == 0) addAtHead(val);
        else if (index == count) addAtTail(val);
        else {
            var current = dummy.next;
            while (--index > 0) current = current.next;
            current.next = new Node(val, current.next);
        count++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) return;
        var current = dummy;
        Node previous = null;
        while (index-- >= 0) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        current.next = null;
        count--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */