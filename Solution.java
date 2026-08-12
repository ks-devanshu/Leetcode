import java.util.Set;
import java.util.HashSet;

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
    int[] preorder, inorder;
    Set<Integer> set = new HashSet<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        
        return construct(0, 0, preorder.length);
    }
    
    private TreeNode construct(int rootIndex, int min, int max) {
        if (min >= max || rootIndex < 0 || rootIndex >= preorder.length) return null;
        
        if (set.contains(preorder[rootIndex])) return null;
        
        var root = new TreeNode(preorder[rootIndex]);
        set.add(root.val);
        
        int mid = 0;
        while ( mid < max && inorder[mid+min] != root.val ) mid++;
        
        root.left = construct(rootIndex+1, min, min+mid);
        root.right = construct(rootIndex+1+mid, min+mid+1, max);
        
        return root;
    }
}