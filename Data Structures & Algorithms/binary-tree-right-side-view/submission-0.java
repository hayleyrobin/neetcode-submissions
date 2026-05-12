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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> q1 = new ArrayDeque<TreeNode>();

        if(root != null) q1.add(root);
        int level = 0;
        while(!q1.isEmpty())
        {
            int levelLength = q1.size();
            for(int i=0; i < levelLength; i++){
                TreeNode curr = q1.removeFirst();
                if(i == (levelLength-1)){
                    list.add(curr.val);
                }
                if(curr.left != null) q1.add(curr.left);
                if(curr.right != null) q1.add(curr.right);
            }
            level++;
        }
        return list;
    }
}
