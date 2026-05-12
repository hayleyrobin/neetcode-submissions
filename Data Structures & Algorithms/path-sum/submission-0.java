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
    int actualSum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null ) return false; // if empty tree return false
        actualSum += root.val;
        if(root.left == null && root.right == null) // if leaf node aka no children, check sum and return
        {
            if(actualSum == targetSum) return true;
            //else {return false;}
        }
        if(hasPathSum(root.left, targetSum)) return true;
        if(hasPathSum(root.right, targetSum)) return true;
        actualSum -= root.val;
        return false;
    }
}