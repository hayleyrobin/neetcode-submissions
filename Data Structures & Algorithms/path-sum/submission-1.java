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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return curPath(root, targetSum, 0);
    }
    public boolean curPath(TreeNode node, int targetSum, int curSum){
        if (node == null) return false;// if empty tree
        
        curSum += node.val;
        //check if curSum == target only at leaf nodes!
        if(node.left == null && node.right == null ) // if a leaf node
        {
            if (curSum == targetSum)
            {
                return true;
            }
            else{
                return false;
            }
        }
    //Return true if either the left subtree has a valid path or the right subtree has a valid path
        if (curPath(node.left, targetSum, curSum)) {
            return true;
        }

        if (curPath(node.right, targetSum, curSum)) {
            return true;
        }
        return false;
    }
}