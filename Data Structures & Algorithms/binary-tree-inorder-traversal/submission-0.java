/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> store;

    public List<Integer> inorderTraversal(TreeNode root) {
        store = new ArrayList<>();
        storeTraversal(root);
        return store;
        
    }
    private void storeTraversal(TreeNode root){
        if(root == null) return; // reached leaf node, return and print
        
        storeTraversal(root.left);
        store.add(root.val);
        storeTraversal(root.right);
    }
}