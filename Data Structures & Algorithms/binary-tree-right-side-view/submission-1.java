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
        List<Integer> rightList = new ArrayList<>();
        bfs(root, rightList);
        return rightList;
    }
    public void bfs(TreeNode root, List<Integer> list){
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.push(root);

        while(!q.isEmpty()){
            int levelLength = q.size();
            
            for(int i=0; i < levelLength; i++){
                TreeNode curNode = q.poll();
                if(i == levelLength - 1) // rightmostNode
                {
                    list.add(curNode.val);
                }
                if(curNode.left != null) {
                    q.add(curNode.left);
                }
                if(curNode.right != null){
                    q.add(curNode.right);
                } 
            }
            
        }
    }
}
