class MyCalendar {

    private class Node {
        private int start, end;
        private Node left, right;
    }

    private Node root;

    public MyCalendar() {

    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node();
            root.start = startTime;
            root.end = endTime;
            return true;
        }

        return isSafe(root, startTime, endTime);
    }

    private boolean isSafe(Node node, int st, int en) {
        if (node == null)
            return true;

        if (st >= node.end) {
            if (isSafe(node.right, st, en)) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.start = st;
                    node.right.end = en;
                }
                return true;
            }
            return false;
        }
        else if (en <= node.start) {
            if (isSafe(node.left, st, en)) {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.start = st;
                    node.left.end = en;
                }
                return true;
            }
            return false;
        }
        else
            return false;
    }


}