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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }         
        else if( val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        return root; // This is the return statement of all the other recursion calls. They only execute (backtrack) after we've already reached the bottom of the tree and created the new node. What we're returning is
        // the root of the current subtree and we're actually always returning the same root that has already been there. So what's the point?
        // Well, it's just a way to implement this backtracking solution without also writing a helper function.
    }
}