import java.util.List;
import java.util.ArrayList;

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
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) return;
        
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}