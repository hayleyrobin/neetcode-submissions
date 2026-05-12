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
        List<List<Integer>> subLists = new ArrayList<>();

        bfs(root, subLists);
        return subLists;
        
    }
    public void bfs(TreeNode root, List<List<Integer>> list){
        Deque<TreeNode> q1 = new ArrayDeque<>();
        int level = 0;
        if(root != null) q1.add(root);

        while(!q1.isEmpty()){
            int levelLength = q1.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0; i < levelLength; i++)
            {
                TreeNode curNode = q1.pop();// pop from queue
                sublist.add(curNode.val);

                if(curNode.left != null){
                    q1.add(curNode.left);
                }
                if(curNode.right != null){
                    q1.add(curNode.right);
                } 
            }
            level++;
            list.add(sublist);
        }
    }
}
