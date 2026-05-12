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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; // if empty or not found in tree

        //  find node
        if(key > root.val) {
            root.right = deleteNode(root.right, key);}
        else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else { // found key
            if(root.left == null || root.right == null){
                // if target node has 0 or 1 child
                if(root.left == null) return root.right;
                else{
                    return root.left;
                }
            }
            // if target node has 2 children
            int maxNode = findMax(root.left); // find max in left subtree
            root.val = maxNode;
            // returns updated root of subtree & assign it back to root.left
            root.left = deleteNode(root.left, maxNode); 
        }
        return root;
    }
    public int findMax(TreeNode root){
        int max = 0;
        //find leaf node(max)
        while(root != null){
            if(root.right == null){
                max = root.val;
            }
            root = root.right;
        }
        return max;
    }
}