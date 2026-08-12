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
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeHelper(root, key);
    }
    
    private TreeNode deleteNodeHelper(TreeNode node, int key) {
        if (node == null) return null;
        
        if (key < node.val)
            node.left = deleteNodeHelper(node.left, key);
        else if (key > node.val)
            node.right = deleteNodeHelper(node.right, key);
        else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                var minNode = getMinNode(node.right);
                node.val = minNode.val;
                node.right = deleteNodeHelper(node.right, node.val);
            }
        }
        return node;
    }
    
    private TreeNode getMinNode(Node root) {
        var current = root;
        while (current != null && current.left != null) current = current.left;
        return current;
    }
}