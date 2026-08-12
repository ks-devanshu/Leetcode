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
    public boolean hasPathSum(TreeNode root, int targetSum) {  
        return hasPathSumHelper(root, 0, targetSum);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int currentSum, int targetSum) {
        if (node == null) return false;
        
        currentSum += node.val;
        if (currentSum == targetSum && node.left == null && node.right == null) return true;
        
        return hasPathSumHelper(node.left, currentSum, targetSum) || hasPathSumHelper(node.right, currentSum, targetSum);
        
    }
}