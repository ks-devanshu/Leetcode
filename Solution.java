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
    private int target;
    public TreeNode searchBST(TreeNode root, int val) {
        target = val;
        return searchInBST(root);
    }
    private TreeNode searchInBST(TreeNode root) {
        if (root == null || root.val == val) return root;
        
        if (target < root.val) return searchInBST(root.left);
        return searchInBST(root.right);
    }
}