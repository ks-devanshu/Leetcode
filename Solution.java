class NumArray {
    private class Node {
        private int sum, min, max;
        private Node left, right;
    }

    private int[] nums;
    private Node root;

    private Node build(int l, int r) {
        if (l == r) {
            Node node = new Node();
            node.sum = nums[l];
            node.min = node.max = l;
            return node;
        }

        Node parent = new Node();
        parent.min = l;
        parent.max = r;
        int mid = (l+r) / 2;
        parent.left = build(l, mid);
        parent.right = build(mid+1, r);
        parent.sum = parent.left.sum + parent.right.sum;

        return parent;
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        root = build(0, nums.length-1);
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(Node node, int index, int value) {
        if (node.min == index && node.max == index) {
            node.sum = value;
            return;
        }

        int mid = (node.min + node.max) / 2;
        if (index > mid)
            update(node.right, index, value);
        else
            update(node.left, index, value);

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }

    private int getSum(Node node, int left, int right) {
        if (left == node.min && node.max == right)
            return node.sum;

        int mid = (node.min + node.max) / 2;
        if (left > mid)
            return getSum(node.right, left, right);
        else if (right <= mid)
            return getSum(node.left, left, right);
        else
            return (getSum(node.left, left, mid) + getSum(node.right, mid+1, right));
    }
}