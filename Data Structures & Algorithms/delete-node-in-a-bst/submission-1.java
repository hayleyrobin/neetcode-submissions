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
        if(root == null) return null;

        // find if key is in tree
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else {
            // if node has 0 children or 1 child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // find "min value" on right side of found "key" node, and replace "key" with that "min value"
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left; // holds a reference to the in-order successor(the smallest node in the right subtree)
            }
          
            cur.left = root.left; // takes the entire left subtree of the node to be deleted (root.left) and attaches it to the left side of smallest node
            TreeNode res = root.right; // saves a reference to the original right subtree of the node to be deleted
            root = null; // detaches old node
            return res; // returns the new, re-rooted subtree. The parent node of the deleted node will now have its child pointer updated to point to res. 
        }
        return root; // passes this new node back up the call stack to the parent of the deleted node.
        // The parent, using the assignment root.right = deleteNode(root.right, key);, updates its child pointer to point to the returned node
    }
}