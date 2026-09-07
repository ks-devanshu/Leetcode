class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
         while (current != null || !stack.isEmpty()) {
         	if (current != null) {
         		preOrder.add(current.val);
         		stack.push(current.right);
         		current = current.left;
         	}
         	else {
         		current = stack.pop();
         	}
         }
         
         return preOrder;
    }
}