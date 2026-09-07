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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        TreeNode current = root;
        stack.push(root);
        visit.push(false);
        
        while (!stack.isEmpty()) {
        	current = stack.pop();
        	var visited = visit.pop();
        	
        	if (current == null) {
        		continue;
        	}
        	
        	if (!visited) {
        		stack.push(current);
        		visit.push(true);
        		stack.push(current.right);
        		visit.push(false);
        		stack.push(current.left);
        		visit.push(false);
        	}
        	else {
        		result.add(current.val);
        	}
        }
        
        return result;
    }
}