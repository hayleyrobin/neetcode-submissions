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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> q1 = new ArrayDeque<TreeNode>();
        
        if(root != null) q1.add(root); // if exists, add root
        int level = 0;

        while(!q1.isEmpty()) // while queue is not empty (not visited all nodes yet)
        {
            int levelLength = q1.size(); // for each child
            List<Integer> sub = new ArrayList<Integer>();
            for(int i = 0; i < levelLength; i++){
                // pop off queue once added to list
                TreeNode curr = q1.removeFirst();
                sub.add(curr.val);
                
                if(curr.left != null) q1.add(curr.left); // add left child to queue if exists
                if(curr.right != null) q1.add(curr.right); // add right child to queue if exists
            }
            list.add(sub);
            level++; // record next level      
        }
        return list;
    }
}
