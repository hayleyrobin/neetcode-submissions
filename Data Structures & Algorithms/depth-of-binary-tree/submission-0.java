/**
Understand
Input: root node of a binary tree
Output: int, the maximum depth of longest path root to lead node
    empty: null -> 0
    one node -> 1
Match
    DFS - Depth First Search
        go down one side first, then the other, and compare
Plan
    if null node: return 0
    if non-null node: return 1 + the depth of the deeper child
Review

Evaluate
    time: O(n) DFS touches every node once
    space:  O(h), where h is the tree height.
        if the tree is skewed( a tree where every node has only one child — all to the left or all to the right?),  the recursion stack go as deep as all nodes
 */
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
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) return 0;

        // get longest path

        // (max depth between left subtree or depth of right subtree)
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
