class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        int index = 0;
        Node current = head;
        Map<Integer, Node> iTn = new HashMap<>();
        Map<Node, Integer> nTi = new HashMap<>();
        iTn.put(-1, null);
        nTi.put(null, -1);
        while (current != null) {
            iTn.put(index, new Node(current.val));
            if (iTn.get(index-1) != null) {
                iTn.get(index-1).next = iTn.get(index);
            }
            nTi.put(current, index);
            current = current.next;
            index++;
        }
        iTn.get(index-1).next = null;
        int count = 0;
        current = head;
        while (current != null) {
            int ind = nTi.get(current.random);
            Node cp = iTn.get(count);
            cp.random = iTn.get(ind);
            current = current.next;
            count++;
        }

        return iTn.get(0);
    }
}