import java.util.Stack;

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
    private Stack<Integer> stack = new Stack<>();
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return (!stack.isEmpty()) ? stack.pop() : null;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) return;
        
        inOrder(node.left);
        if (stack.size() < k)
            stack.push(node.val);
        inOrder(node.right);
    }
}