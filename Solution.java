class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
}
 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean swap = q.val < p.val;
        if (swap) return lowestCommonAncestorHelper(root, q, p);
        return lowestCommonAncestorHelper(root, p, q);
                
    }
    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        var current = root.val;
        if (current == p.val || current == q.val || (p.val < current && q.val > current)) return root;
        
        if (q.val < current) return lowestCommonAncestorHelper(root.left, p, q);
        return lowestCommonAncestorHelper(root.right, p , q);
    }
}