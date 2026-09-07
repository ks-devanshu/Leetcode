class Solution {
    private class Node {
        private int count, l, r;
        private Node left, right;
        
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
            count = 0;
        }
    }
    
    private Node build(int min, int max) {
        if (min == max)
            return new Node(min, max);
        
        Node parent = new Node(min, max);
        int mid = (max+min)/2;
        parent.left = build(min, mid);
        parent.right = build(mid+1, max);
        
        parent.count = Math.max(parent.left.count, parent.right.count);
        
        return parent;
    }
    
    private int search(Node node, int min, int max) {
        if (max < min) return 0;
        if (node.l == min && node.r == max)
            return node.count;

        int mid = (node.l+node.r)/2;
        if (max <= mid)
            return search(node.left, min, max);
        else if (min > mid)
            return search(node.right, min, max);
        else
            return Math.max( search(node.left, min, mid), search(node.right, mid+1, max) );
    }
    
    private void update(Node node, int num, int value) {
        if (node.l == num && node.r == num) {
            node.count = Math.max(node.count, value);
            return;
        }
        
        int mid = (node.l+node.r)/2;
        if (num > mid) {
            update(node.right, num, value);
        }
        else {
            update(node.left, num, value);
        }
        
        node.count = Math.max(node.left.count, node.right.count);
    }
        
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
    	int max = 0;
    	for (var num : nums)
    		max = Math.max(max, num);
    	Node root = build(1, max);
    	
    	for (var num : nums) {
    		int query = search(root,Math.max(1, num-k), num-1) + 1;
    		update(root, num, query);
    	}
    	
    	return search(root, 1,max);
    }
}
