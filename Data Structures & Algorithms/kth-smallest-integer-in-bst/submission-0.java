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
    private List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        list.add(0);
        inorderTravels(root);
        return list.get(k);
    }
    private void inorderTravels(TreeNode root){
        if(root == null) return;

        inorderTravels(root.left);
        list.add(root.val);
        inorderTravels(root.right);
    }
}
