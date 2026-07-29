/**
Understand
Input: two roots of trees
Output: boolean, if these trees are the same (both values and structure) or not
    Small Cases:
        both roots are null - true
        one null, one non-null - false
        two non-null roots but diff values - false
 Match
    Recursion on a tree:
        top-down compare the current nodes first
 Plan
    base case: null checks
        if nodes are null
    check if values are the same
        value checks:
            p.val != q.val
    if values are the same, recursive child checks:
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) 
Evaluate
    Time: O(n) where n is the total number of nodes visited across both trees.
        Write it as O(n + m) if you name them separately, or just define N = n + m and write O(N)
    Space: 
        In the worst case, space is O(H), and if the tree is skewed, that becomes O(n).
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // null checks!
        if(p == null && q == null) return true; // same structure
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;

        // value check on current nodes
        if(p.val != q.val) return false;

        // if values are the same, check children structure!
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
