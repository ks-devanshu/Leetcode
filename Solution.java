public class TreeNode {
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

class BSTIterator {
	
	private List<Integer> inorder = new ArrayList<>();
	private int pointer = 0, count;

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
        	if (current != null) {
        		stack.push(current);
        		current = current.left;
        	}
        	else {
        		var parent = stack.pop();
        		inorder.add(parent.val);
        		count++;
        		current = parent.right;
        	}
        }
    }
    
    public int next() {
        return inorder.get(pointer++);
    }
    
    public boolean hasNext() {
        return pointer < count;
    }
}
